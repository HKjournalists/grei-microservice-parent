package data.repository;

import data.entity.CourseQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * i3 course quiz
 * Created by 刘佳兴 on 16-4-26.
 */
@Repository
public interface CourseQuizRepository extends JpaRepository<CourseQuiz, Long>, JpaSpecificationExecutor<CourseQuiz> {

}
