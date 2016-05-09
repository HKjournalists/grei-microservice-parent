package data.service;

import data.entity.Attachment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 刘佳兴
 * @version V1.0
 */
public interface StorageService {

    String write(InputStream inputStream, Attachment attachment) throws IOException;

    File read(String path);

}
