package data.service.impl

import java.io.{BufferedOutputStream, File, FileOutputStream, InputStream}
import java.util.UUID

import data.entity.Attachment
import data.service.StorageService
import org.springframework.stereotype.Service
import org.springframework.util.FileCopyUtils

/**
  * local storage strategy
  *
  * @author 刘佳兴
  * @version V1.0
  */
@Service
class LocalStorageService extends StorageService{

  val storagePath = "/tmp"

  override def write(inputStream: InputStream, attachment: Attachment): Unit = {
    val stream = new BufferedOutputStream(new FileOutputStream(new File(storagePath + attachment.relativePath + attachment.name + attachment.suffix)))
    FileCopyUtils.copy(inputStream, stream)
  }

  override def read(path: String): File = {
    new File(storagePath + path)
  }

}
