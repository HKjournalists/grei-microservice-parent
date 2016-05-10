package data.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import data.entity.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.InputStream;

/**
 * Amazon s3 cloud storage service
 *
 * @author 刘佳兴
 * @version V1.0
 */
@Slf4j
public class AmazonS3Service implements StorageService{

    private AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());

    @Value("${storage.amazonS3.enable}")
    Boolean enable = false;

    @Value("${storage.amazonS3.bucket}")
    String bucket;

    @Value("${storage.amazonS3.endpoint}")
    String endpoint;


    @Override
    public Boolean enable() {
        return enable;
    }

    @Override
    public String endpoint() {
        return endpoint;
    }

    @Override
    public String key(Attachment attachment) {
        return attachment.getRelativePath() + File.separator + attachment.getName();
    }

    @Override
    public String write(InputStream inputStream, Attachment attachment) {
        log.info("Uploading a new object to S3 from a file\n");
        try {
            s3client.putObject(new PutObjectRequest(bucket, key(attachment), inputStream, new ObjectMetadata()));
        } catch (AmazonServiceException ase) {
            log.info("AmazonServiceException: {}", ase.getMessage());
        } catch (AmazonClientException ace) {
            log.info("AmazonClientException: {}", ace.getMessage());
        }

        return endpoint + key(attachment);
    }

    @Override
    public InputStream read(Attachment attachment) {
        S3Object s3Object = s3client.getObject(bucket, key(attachment));
        return s3Object.getObjectContent();
    }


}
