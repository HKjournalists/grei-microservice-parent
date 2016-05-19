package data.web;

import data.entity.CourseLessonSlide;
import data.query.QCourseLessonSlide;
import data.repository.CourseLessonSlideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 刘佳兴
 */
@RestController
public class LessonCourseSlideController {

    @Autowired
    CourseLessonSlideRepository courseLessonSlideRepository;

    @RequestMapping(value = "/courses/{courseId}/lessons/{lessonId}/slides", method = RequestMethod.POST)
    CourseLessonSlide create(@PathVariable Long courseId, @PathVariable Long lessonId, @RequestBody CourseLessonSlide courseLessonSlide) {
        return courseLessonSlideRepository.save(courseLessonSlide);
    }

    @RequestMapping(value = "/courses/{courseId}/lessons/{lessonId}/slides/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable Long courseId, @PathVariable Long lessonId, @PathVariable Long id) {
        courseLessonSlideRepository.delete(id);
    }

    @RequestMapping(value = "/courses/{courseId}/lessons/{lessonId}/slides/{id}", method = RequestMethod.GET)
    CourseLessonSlide findOne(@PathVariable Long courseId, @PathVariable Long lessonId, @PathVariable Long id) {
        return courseLessonSlideRepository.findOne(id);
    }

    @RequestMapping(value = "/courses/{courseId}/lessons/{lessonId}/slides", method = RequestMethod.GET)
    List<CourseLessonSlide> courseLessons(@PathVariable Long courseId, @PathVariable Long lessonId, QCourseLessonSlide qCourseLessonSlide) {
        qCourseLessonSlide.setCourseid(courseId);
        qCourseLessonSlide.setLessonid(lessonId);
        return courseLessonSlideRepository.findAll(qCourseLessonSlide);
    }

}
