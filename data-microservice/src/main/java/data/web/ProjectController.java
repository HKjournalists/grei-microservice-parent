package data.web;

import data.entity.Project;
import data.entity.query.QProject;
import data.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@RestController
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "/projects/search", method = RequestMethod.GET)
    ResponseEntity page(QProject qproject, Pageable pageable) {
        Page<Project> projects = projectRepository.findAll(qproject, pageable);
        return ResponseEntity.ok(projects);
    }

}
