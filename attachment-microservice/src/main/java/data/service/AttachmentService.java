package data.service;

import data.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 刘佳兴
 * @version V1.0
 */
public interface AttachmentService {

    /**
     * save attachment and storage file
     *
     * @param multipartFile MultipartFile
     * @param relativePath  相对存储路径
     * @return
     */
    Attachment save(MultipartFile multipartFile, String relativePath) throws IOException;


    File get(String name);

}
