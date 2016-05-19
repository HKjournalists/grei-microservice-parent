package data.web;

import data.entity.Attachment;
import data.repository.AttachmentRepository;
import data.service.AttachmentService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rx.Single;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 刘佳兴
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
    public ResponseEntity<Attachment> upload(@RequestParam(name = "file")MultipartFile multipartFile, @PathVariable String relativePath) throws IOException {
        if(multipartFile.isEmpty()) ResponseEntity.ok();
        if(!StringUtils.isEmpty(relativePath)) relativePath = relativePath.replaceAll("\\.", File.separator);

        Attachment attachment = new Attachment(UUID.randomUUID().toString(), multipartFile.getOriginalFilename(),
                relativePath, multipartFile.getContentType(), multipartFile.getSize());
        attachment = attachmentService.save(multipartFile.getInputStream(), attachment);

        return ResponseEntity.ok(attachment);
    }

    /**
     * 获取文件信息
     *
     * @param name uuid
     * @return ResponseEntity<Attachment>
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Attachment> get(@PathVariable(value = "name")String name) {
        Attachment attachment = attachmentService.get(name);
        return ResponseEntity.ok(attachment);
    }

    /**
     * 获取文件信息
     *
     * @param name uuid
     * @return 文件DTO（Data Transform Object）对象
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Attachment> remove(@PathVariable(value = "name")String name) {
        Attachment attachment = attachmentService.remove(name);
        return ResponseEntity.ok(attachment);
    }

    /**
     * 获取文件流
     *
     * @param name uuid
     * @return ResponseEntity<String>
     */
    @RequestMapping(value = "/read/{name}", method = RequestMethod.GET)
    public byte[] read(@PathVariable(value = "name")String name) throws IOException {
        return IOUtils.toByteArray(attachmentService.read(name));
    }

}
