package data.entity.query

import javax.persistence.criteria.{CriteriaBuilder, CriteriaQuery, Predicate, Root}

import data.entity.Attachment
import org.springframework.data.jpa.domain.Specification

import scala.collection.mutable.ArrayBuffer

/**
  * attachment query
  *
  * @author 刘佳兴
  * @version V1.0
  */
class QAttachment extends Attachment with Specification[Attachment] {

  override def toPredicate(root: Root[Attachment], query: CriteriaQuery[_], cb: CriteriaBuilder): Predicate = {
    val predicates = new ArrayBuffer[Predicate]

    if(this.id != 0) predicates += cb.equal(root.get("id"), this.id)

    if(!this.name.isEmpty) predicates += cb.equal(root.get("name"), this.name)

    query.where(predicates.toArray : _*).getRestriction
  }

  def this(name: String) = {
    this()
    this.name = name
  }

}
