package data.service;

import com.amazonaws.services.ec2.model.Storage;
import data.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 使用存储
 *
 * @author 刘佳兴
 * @version V1.0
 */
public interface AttachmentService {

    /**
     * save attachment and storage file
     *
     * @param multipartFile MultipartFile
     * @param relativePath  相对存储路径(根据业务自身定义)
     * @return Attachment
     */
    Attachment save(MultipartFile multipartFile, String relativePath) throws IOException;

    /**
     * soft remove by name
     *
     * @param name uuid
     * @return Attachment
     */
    Attachment remove(String name);

    /**
     * get attachment by name
     *
     * @param name uuid
     * @return Attachment
     */
    Attachment get(String name);

    /**
     * get attachment file by name
     *
     * @param name uuid
     * @return File
     */
    File read(String name);

}
