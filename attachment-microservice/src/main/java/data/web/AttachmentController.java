package data.web;

import data.dto.AttachmentData;
import data.entity.Attachment;
import data.service.AttachmentService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@RestController
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    /**
     * upload file
     *
     * @param multipartFile multipartFile
     * @param relativePath  business path
     * @return ResponseEntity<AttachmentData>
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<AttachmentData> upload(@RequestParam(name = "file")MultipartFile multipartFile, @RequestParam(name = "relativePath")String relativePath) throws IOException {
        if(multipartFile.isEmpty()) ResponseEntity.ok();
        Attachment attachment = attachmentService.save(multipartFile, relativePath);
        return ResponseEntity.ok(new AttachmentData(attachment.getName(), attachment.getUrls().get(0)));
    }

    /**
     * get file stream
     *
     * @param name uuid
     * @param response response outputstream
     * @return ResponseEntity<String>
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> read(@PathVariable(value = "name")String name, HttpServletResponse response) throws IOException {
        FileSystemResource systemResource = new FileSystemResource(attachmentService.get(name));
        FileCopyUtils.copy(systemResource.getInputStream(), response.getOutputStream());
        return ResponseEntity.ok("Success");
    }

}
