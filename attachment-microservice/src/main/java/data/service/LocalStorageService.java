package data.service;

import data.entity.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.*;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@Slf4j
@Service
public class LocalStorageService implements StorageService {

    @Value("${storage.local.bucket}")
    String bucket;

    @Value("${storage.local.endpoint}")
    String endpoint;

    Boolean enable = true;

    @Override
    public Boolean enable() {
        return enable;
    }

    @Override
    public String write(InputStream inputStream, Attachment attachment) {
        log.info("Uploading a new object to local from a file\n");
        try {
            File file = new File(key(attachment));
            file.getParentFile().mkdirs();
            OutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
            FileCopyUtils.copy(inputStream, stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return endpoint + attachment.getName();
    }

    @Override
    public String endpoint() {
        return endpoint;
    }

    @Override
    public InputStream read(Attachment attachment) {
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(new File(key(attachment))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    @Override
    public String key(Attachment attachment) {
        return bucket + File.separator + attachment.getRelativePath() + attachment.getName();
    }

}
