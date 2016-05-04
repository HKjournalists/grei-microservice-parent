package data.entity

import javax.persistence.{Column, Entity, Table}

import scala.beans.BeanProperty

/**
  * 附件实体类
  *
  * @author 刘佳兴
  * @version V1.0
  */
@Entity
@Table(name = "attachment")
class Attachment() extends BaseEntity {

  def STORAGE_LOCAL = "local"
  def STORAGE_ALI_OSS = "ali_oss"
  def STORAGE_AMAZON_S3 = "amazon_s3"

  //UUID名称
  @BeanProperty()
  var name: String = _

  //真实名称
  @BeanProperty
  var realName: String = _

  //上传的相对路径
  @BeanProperty
  var relativePath: String = _

  //后缀名
  @Column(length = 30)
  @BeanProperty
  var contentType: String = _

  //存储方式
  @BeanProperty
  var storage: String = _

  //文件长度
  @BeanProperty
  var length: Long = _


}
