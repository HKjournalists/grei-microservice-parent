package data.service.impl;

import data.entity.Attachment;
import data.entity.query.QAttachment;
import data.repository.AttachmentRepository;
import data.service.AttachmentService;
import data.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    StorageService localStorageService;

    @Override
    public Attachment save(MultipartFile file, String relativePath) throws IOException {
        Attachment attachment = new Attachment(UUID.randomUUID().toString(), file.getOriginalFilename(), relativePath, file.getContentType(), file.getSize());

        attachment.setUrl(localStorageService.write(file.getInputStream(), attachment));

        return attachmentRepository.save(attachment);
    }

    @Override
    public Attachment remove(String name) {
        Attachment attachment = attachmentRepository.findOne(new QAttachment(name));
        attachment.setDeleted(true);
        return attachmentRepository.save(attachment);
    }

    @Override
    public Attachment get(String name) {
        Attachment attachment = attachmentRepository.findOne(new QAttachment(name));
        attachment.setUrl(localStorageService.endpoint() + name);
        return attachment;
    }

    @Override
    public InputStream read(String name) {
        Attachment attachment = attachmentRepository.findOne(new QAttachment(name));
        return localStorageService.read(attachment);
    }

}
