package data.web;

import data.entity.Course;
import data.query.QCourse;
import data.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author 刘佳兴
 */
@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    Course create(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable Long id) {
        courseRepository.delete(id);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    Course findOne(@PathVariable Long id) {
        return courseRepository.findOne(id);
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    Page<Course> page(QCourse qCourse, Pageable pageable) {
        return courseRepository.findAll(qCourse, pageable);
    }

}
