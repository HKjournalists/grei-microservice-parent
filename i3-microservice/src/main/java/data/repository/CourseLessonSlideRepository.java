package data.repository;

import data.entity.CourseLessonSlide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * i3 course lesson slide repository
 * Created by 刘佳兴 on 16-3-17.
 */
@Repository
public interface CourseLessonSlideRepository extends JpaRepository<CourseLessonSlide, Long>, JpaSpecificationExecutor<CourseLessonSlide> {

}
