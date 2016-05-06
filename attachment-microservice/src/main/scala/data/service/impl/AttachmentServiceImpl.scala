package data.service.impl

import java.io.File
import java.util.UUID

import data.DTO.AttachmentData
import data.entity.Attachment
import data.entity.query.QAttachment
import data.repository.AttachmentRepository
import data.service.{AttachmentService, StorageService}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

/**
  * attachment service implement
  *
  * @author 刘佳兴
  * @version V1.0
  */
@Service
class AttachmentServiceImpl extends AttachmentService {

  @Autowired
  var attachmentRepository: AttachmentRepository = _
  @Autowired
  var localStorageService: StorageService = _

  override def save(file: MultipartFile, relativePath: String): Attachment = {
    val attachment = new Attachment(UUID.randomUUID().toString, file.getName, relativePath, file.getContentType,
      file.getSize, file.getOriginalFilename.replace(file.getName, ""))

    localStorageService.write(file.getInputStream, attachment)

    attachmentRepository.save(attachment)
  }

  override def get(name: String): File = {
    val attachment = attachmentRepository.findOne(new QAttachment(name))
    localStorageService.read(attachment.getRelativePath + attachment.name + attachment.suffix)
  }

}
