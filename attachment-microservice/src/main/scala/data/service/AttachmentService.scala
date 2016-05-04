package data.service

import data.DTO.AttachmentData
import data.entity.Attachment
import org.springframework.web.multipart.MultipartFile

/**
  * attachment service
  *
  * @author 刘佳兴
  * @version V1.0
  */
trait AttachmentService {

  def save(multipartFile: MultipartFile): Attachment

}
