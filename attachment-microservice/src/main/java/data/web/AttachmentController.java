package data.web;

import data.dto.AttachmentData;
import data.entity.Attachment;
import data.repository.AttachmentRepository;
import data.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@RestController
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;
    @Autowired
    AttachmentRepository attachmentRepository;

    /**
     * 上传文件
     *
     * @param multipartFile multipartFile
     * @param relativePath  business path pattern(a.b.c.d...)
     * @return ResponseEntity<AttachmentData>
     */
    @RequestMapping(value = "/upload/{relativePath}", method = RequestMethod.POST)
    public ResponseEntity<AttachmentData> upload(@RequestParam(name = "file")MultipartFile multipartFile, @PathVariable String relativePath) throws IOException {
        if(multipartFile.isEmpty()) ResponseEntity.ok();
        if(!StringUtils.isEmpty(relativePath)) relativePath = relativePath.replaceAll("\\.", File.separator);

        Attachment attachment = new Attachment(UUID.randomUUID().toString(), multipartFile.getOriginalFilename(),
                relativePath, multipartFile.getContentType(), multipartFile.getSize());
        attachment = attachmentService.save(multipartFile.getInputStream(), attachment);

        return ResponseEntity.ok(new AttachmentData(attachment.getName(), attachment.getUrl()));
    }

    /**
     * 获取文件信息
     *
     * @param name uuid
     * @return ResponseEntity<AttachmentData>
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<AttachmentData> get(@PathVariable(value = "name")String name) {
        Attachment attachment = attachmentService.get(name);
        return ResponseEntity.ok(new AttachmentData(attachment.getName(), attachment.getUrl()));
    }

    /**
     * 获取文件信息
     *
     * @param name uuid
     * @return 文件DTO（Data Transform Object）对象
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<AttachmentData> remove(@PathVariable(value = "name")String name) {
        Attachment attachment = attachmentService.remove(name);
        return ResponseEntity.ok(new AttachmentData(attachment.getName(), attachment.getUrl()));
    }

    /**
     * 获取文件流
     *
     * @param name uuid
     * @param response response OutputStream
     * @return ResponseEntity<String>
     */
    @RequestMapping(value = "/read/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> read(@PathVariable(value = "name")String name, HttpServletResponse response) throws IOException {
        FileCopyUtils.copy(attachmentService.read(name), response.getOutputStream());
        return ResponseEntity.ok("Success");
    }

}
