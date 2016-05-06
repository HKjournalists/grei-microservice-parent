package data.service

import java.io.{File, InputStream}

import data.entity.Attachment

/**
  * storage service
  *
  * @author 刘佳兴
  * @version V1.0
  */
trait StorageService {

  def write(inputStream: InputStream, attachment: Attachment) : Unit

  def read(path: String): File

}
