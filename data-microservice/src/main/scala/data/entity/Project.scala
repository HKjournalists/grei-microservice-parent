package data.entity

import javax.persistence._
import javax.persistence.criteria.{CriteriaBuilder, CriteriaQuery, Predicate, Root}

import org.springframework.data.jpa.domain.Specification

import scala.beans.BeanProperty
import scala.collection.mutable.ArrayBuffer

/**
  * project
  * Created by 刘佳兴 on 16-4-16.
  */
@Entity
@Table(name = "project")
case class Project() extends Specification[Project] {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  @BeanProperty
  var id: Long = _

  @Column(name = "projectname")
  @BeanProperty
  var projectname: String = _

  @Override
  def toPredicate(root :Root[Project], query :CriteriaQuery[_], cb :CriteriaBuilder ) :Predicate = {
    val predicates = new ArrayBuffer[Predicate]

    predicates += cb.equal(root.get("id"), this.id)

    query.where(predicates.toArray : _*).getRestriction
  }

}
