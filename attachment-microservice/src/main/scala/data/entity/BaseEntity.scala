package data.entity

import javax.persistence._
import java.util.Date

import scala.beans.BeanProperty

/**
  * 公共的属性映射
  *
  * @author 刘佳兴
  * @version V1.0
  */
@MappedSuperclass
trait BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  @BeanProperty
  var id: Long = _

  @Column(name = "createdby")
  @BeanProperty
  var createdBy: Long = _

  @Column(name = "createdat")
  @BeanProperty
  var createdAt: Date = _

  @Column(name = "updatedby")
  @BeanProperty
  var updatedBy: Long = _

  @Column(name = "updatedat")
  @BeanProperty
  var updatedAt: Date = _

  //逻辑删除操作，子类需要添加: @where(clause="deleted=0")
  @Column(name = "deleted")
  @BeanProperty
  var deleted: Boolean = _

  @PrePersist
  def created(): Unit = {
    this.createdAt = new Date()
    this.updatedAt = createdAt
  }

  @PreUpdate
  def updated(): Unit = {
    this.updatedAt = new Date()
  }

}
