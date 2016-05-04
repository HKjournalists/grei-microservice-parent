package data.service.impl

import data.DTO.AttachmentData
import data.entity.Attachment
import data.repository.AttachmentRepository
import data.service.{AttachmentService, StorageService}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.multipart.MultipartFile

/**
  * attachment service implement
  *
  * @author 刘佳兴
  * @version V1.0
  */
class AttachmentServiceImpl extends AttachmentService {

  @Autowired
  var attachmentRepository: AttachmentRepository = _
  @Autowired
  var localStorageService: StorageService = _

  override def save(multipartFile: MultipartFile): AttachmentData = {
    val name = localStorageService.write(multipartFile)
    val attachment = Attachment()
    attachmentRepository.save(attachment)
  }

}
