package data.service;

import data.entity.Attachment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 存储服务类，实现类为本地存储和云存储
 *
 * @author 刘佳兴
 * @version V1.0
 */
public interface StorageService {

    Boolean enable();

    /**
     * 外网访问根路径
     *
     * @return 根路径
     */
    String endpoint();

    /**
     * key 表示文件路径
     *
     * @param attachment 文件对象
     * @return 相对路径
     */
    String key(Attachment attachment);

    /**
     * 写入文件流
     *
     * @param inputStream 上传文件输入流
     * @param attachment  文件相关信息
     * @return 可访问路径
     */
    String write(InputStream inputStream, Attachment attachment);

    /**
     * 根据文件信息读取文件流
     *
     * @param attachment 文件相关信息
     * @return 读取文件流
     */
    InputStream read(Attachment attachment);

}
