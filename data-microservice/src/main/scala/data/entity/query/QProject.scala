package data.entity.query

import javax.persistence.criteria.{CriteriaBuilder, CriteriaQuery, Predicate, Root}

import data.entity.Project
import org.springframework.data.jpa.domain.Specification

import scala.collection.mutable.ArrayBuffer

/**
  * query project
  *
  * @author 刘佳兴
  * @version V1.0
  */
class QProject extends Project with Specification[Project] {

  @Override
  def toPredicate(root :Root[Project], query :CriteriaQuery[_], cb :CriteriaBuilder ): Predicate = {
    val predicates = new ArrayBuffer[Predicate]

    if(this.id != 0) predicates += cb.equal(root.get("id"), this.id)

    query.where(predicates.toArray : _*).getRestriction
  }

}
