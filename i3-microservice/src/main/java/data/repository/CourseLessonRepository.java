package data.repository;


import data.entity.CourseLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * i3 course lesson repository Created by 刘佳兴 on 16-3-17.
 */
@Repository
public interface CourseLessonRepository extends JpaRepository<CourseLesson, Long>, JpaSpecificationExecutor<CourseLesson> {

}
