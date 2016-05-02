package data.web;

import data.entity.Project;
import data.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Project Controller
 * Created by 刘佳兴 on 16-4-21.
 */
@RepositoryRestController
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "/projects/search", method = RequestMethod.GET)
    ResponseEntity page(Project project, Pageable pageable) {
        Page<Project> projects = projectRepository.findAll(project, pageable);

        Resources resources = new Resources<Project>(projects);
        resources.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ProjectController.class).page(project, pageable)).withSelfRel());

        return ResponseEntity.ok(resources);
    }

}
