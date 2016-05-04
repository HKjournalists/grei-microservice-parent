package data.service

import java.io.File

import org.springframework.web.multipart.MultipartFile

/**
  * storage service
  *
  * @author 刘佳兴
  * @version V1.0
  */
trait StorageService {

  def write(multipartFile: MultipartFile) : String

  def read(path: String): File

}
