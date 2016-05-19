package data.service;

import data.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 文件信服务类
 *
 * @author 刘佳兴
 */
public interface AttachmentService {

    /**
     * save attachment and storage file
     *
     * @param inputStream  文件上传流
     * @param attachment   附件对象
     * @return Attachment
     */
    Attachment save(InputStream inputStream, Attachment attachment);

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
     * 读取文件
     *
     * @param name uuid
     * @return 读取文件流
     */
    InputStream read(String name);

}
