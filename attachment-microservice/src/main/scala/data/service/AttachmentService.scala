package data.service

import java.io.File

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

  /**
    * save attachment and storage file
    *
    * @param multipartFile MultipartFile
    * @param relativePath  相对存储路径
    * @return
    */
  def save(multipartFile: MultipartFile, relativePath: String): Attachment


  def get(name: String): File

}
