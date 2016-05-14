package data.repository;


import data.entity.I3CourseLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * i3 course lesson repository Created by 刘佳兴 on 16-3-17.
 */
@Repository
public interface I3CourseLessonRepository extends JpaRepository<I3CourseLesson, Long>, JpaSpecificationExecutor<I3CourseLesson> {

}
