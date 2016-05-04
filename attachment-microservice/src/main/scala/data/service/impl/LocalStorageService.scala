package data.service.impl

import java.io.{BufferedOutputStream, File, FileOutputStream}
import java.util.UUID

import data.service.StorageService
import org.springframework.stereotype.Service
import org.springframework.util.FileCopyUtils
import org.springframework.web.multipart.MultipartFile

/**
  * local storage strategy
  *
  * @author 刘佳兴
  * @version V1.0
  */
@Service
class LocalStorageService extends StorageService{

  val storagePath = "/tmp/"

  override def write(file: MultipartFile): String = {
    val uuid = UUID.randomUUID().toString
    val stream = new BufferedOutputStream(new FileOutputStream(new File(storagePath + uuid)))
    FileCopyUtils.copy(file.getInputStream, stream)
    uuid
  }

  override def read(path: String): File = {
    new File(storagePath + path)
  }

}
