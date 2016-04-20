package data.repository

import data.entity.Project
import org.springframework.data.jpa.repository.{JpaRepository, JpaSpecificationExecutor}
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
  * Created by 刘佳兴 on 16-4-16.
  */
@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
trait ProjectRepository extends JpaRepository[Project, java.lang.Long] with JpaSpecificationExecutor[Project]
