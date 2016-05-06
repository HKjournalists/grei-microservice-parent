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
class Attachment extends BaseEntity {

  //UUID名称
  @BeanProperty
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

  //文件大小
  @BeanProperty
  var size: Long = _

  //后缀名
  @BeanProperty
  var suffix: String = _

  def this(id: Long) {
    this()
    this.id = id
  }

  def this(name: String, realName: String, relativePath: String, contentType: String, size: Long, suffix: String) {
    this()
    this.name = name
    this.realName = realName
    this.relativePath = relativePath
    this.contentType = contentType
    this.suffix = suffix
    this.size = size
  }

  override def toString = s"Attachment($name, $realName, $relativePath, $contentType, $size, $suffix)"
}
