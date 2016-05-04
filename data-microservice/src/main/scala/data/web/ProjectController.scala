package data.web

import data.entity.Project
import data.entity.query.QProject
import data.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}

/**
  * @author 刘佳兴
  * @version V1.0
  */
@RestController
class ProjectController {

  @Autowired
  val projectRepository: ProjectRepository = null

  @RequestMapping(value = Array("/projects/search"), method = Array(RequestMethod.GET))
  def page(qProject: QProject, pageable: Pageable): ResponseEntity[_] = {
    ResponseEntity.ok(projectRepository.findAll(qProject, pageable))
  }

}
