package data.service;

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
        File file = new File(storagePath + File.separator + attachment.getRelativePath() + attachment.getName());
        file.getParentFile().mkdirs();
        OutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
        FileCopyUtils.copy(inputStream, stream);
        return url + attachment.getName();
    }

    @Override
    public String serviceAddress() {
        return url;
    }

    @Override
    public File read(String path) {
        return new File(storagePath + path);
    }

}
