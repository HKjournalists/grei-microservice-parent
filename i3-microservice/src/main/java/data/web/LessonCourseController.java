package data.web;

import data.entity.Course;
import data.entity.CourseLesson;
import data.query.QCourse;
import data.query.QCourseLesson;
import data.repository.CourseLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

/**
 * @author 刘佳兴
 */
@RestController
public class LessonCourseController {

    @Autowired
    CourseLessonRepository courseLessonRepository;

    @RequestMapping(value = "/courses/{courseId}/lessons", method = RequestMethod.POST)
    CourseLesson create(@PathVariable Long courseId, @RequestBody CourseLesson courseLesson) {
        courseLesson.setCourseid(courseId);
        return courseLessonRepository.save(courseLesson);
    }

    @RequestMapping(value = "/courses/{courseId}/lessons/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable Long courseId, @PathVariable Long id) {
        courseLessonRepository.delete(id);
    }

    @RequestMapping(value = "/courses/{courseId}/lessons/{id}", method = RequestMethod.GET)
    CourseLesson findOne(@PathVariable Long courseId, @PathVariable Long id) {
        return courseLessonRepository.findOne(id);
    }

    @RequestMapping(value = "/courses/{courseId}", method = RequestMethod.GET)
    List<CourseLesson> courseLessons(@PathVariable Long courseId, QCourseLesson qCourseLesson) {
        qCourseLesson.setCourseid(courseId);
        return courseLessonRepository.findAll(qCourseLesson);
    }

    @RequestMapping(value = "/courses/{courseId}lessons", method = RequestMethod.GET)
    Page<CourseLesson> page(@PathVariable Long courseId, QCourseLesson qCourseLesson, Pageable pageable) {
        qCourseLesson.setCourseid(courseId);
        return courseLessonRepository.findAll(qCourseLesson, pageable);
    }

}
