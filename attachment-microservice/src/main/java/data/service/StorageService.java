package data.service;

import data.entity.Attachment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 存储服务类，实现类为本地存储和云存储
 *
 * @author 刘佳兴
 * @version V1.0
 */
public interface StorageService {

    String serviceAddress();

    String write(InputStream inputStream, Attachment attachment) throws IOException;

    File read(String path);

}
