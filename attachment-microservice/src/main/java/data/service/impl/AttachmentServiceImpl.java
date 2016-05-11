package data.service.impl;

import data.entity.Attachment;
import data.entity.query.QAttachment;
import data.repository.AttachmentRepository;
import data.service.AttachmentService;
import data.service.StorageService;
import jdk.internal.util.xml.impl.Input;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@Slf4j
@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    List<StorageService> storageServices;

    @Override
    public Attachment save(InputStream inputStream, Attachment attachment) {
        storageServices.stream()
                .filter(StorageService::enable)
                .sorted((s1, s2) -> s1.priority() - s2.priority())
                .forEach(storageService -> {
                    attachment.setUrl(storageService.write(inputStream, attachment));
                });

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
        Optional<StorageService> optional = storageServices.stream()
                .filter(StorageService::enable)
                .max((s1, s2) -> (s1.priority() - s2.priority()));

        if(!optional.isPresent()) throw new RuntimeException("Couldn't find highest priority target");

        StorageService storageService = optional.get();
        attachment.setUrl(storageService.endpoint() + attachment.getName());

        return attachment;
    }

    @Override
    public InputStream read(String name) {
        Attachment attachment = attachmentRepository.findOne(new QAttachment(name));

        Optional<StorageService> optional = storageServices.stream()
                .filter(StorageService::enable)
                .max((s1, s2) -> (s1.priority() - s2.priority()));

        if(!optional.isPresent()) throw new RuntimeException("Couldn't find highest priority target");

        return optional.get().read(attachment);
    }

}
