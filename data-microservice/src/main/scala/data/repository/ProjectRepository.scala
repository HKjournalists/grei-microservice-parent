package data.repository

import data.entity.Project
import org.springframework.data.jpa.repository.{JpaRepository, JpaSpecificationExecutor}
import org.springframework.stereotype.Repository

/**
  * @author 刘佳兴
  * @version V1.0
  */
@Repository
trait ProjectRepository extends JpaRepository[Project, java.lang.Long] with JpaSpecificationExecutor[Project] {

}
