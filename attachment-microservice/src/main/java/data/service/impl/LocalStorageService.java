package data.service.impl;

import data.entity.Attachment;
import data.service.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.*;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@Service
public class LocalStorageService implements StorageService {

    @Value("${storage.local.path}")
    String storagePath;
    @Value("${storage.local.url}")
    String url;

    @Override
    public String write(InputStream inputStream, Attachment attachment) throws IOException {
        OutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(storagePath + File.separator + attachment.getRelativePath() + attachment.getName())));
        FileCopyUtils.copy(inputStream, stream);
        return url + attachment.getName();
    }

    @Override
    public File read(String path) {
        return new File(storagePath + path);
    }

}
