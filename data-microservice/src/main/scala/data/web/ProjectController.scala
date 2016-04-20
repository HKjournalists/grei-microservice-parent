package data.web

import data.entity.Project
import data.repository.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.hateoas.Resources
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, ResponseBody}


/**
  * project controller
  * Created by 刘佳兴 on 16-4-16.
  */
@RepositoryRestController
class ProjectController {

  @Autowired
  var projectRepository: ProjectRepository = _

  @RequestMapping(value = Array("/projects/search"), method = Array(RequestMethod.GET))
  @ResponseBody
  def page(project: Project, pageable: Pageable): ResponseEntity[_] = {
    val projects = projectRepository.findAll(project, pageable)
    val resources = new Resources[Project](projects)
    resources.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(classOf[ProjectController]).page(project, pageable)).withSelfRel)
    ResponseEntity.ok(resources)
  }

}
