package data.repository;

import data.entity.I3CourseQuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * i3 course quiz question
 * Created by 刘佳兴 on 16-4-26.
 */
@Repository
public interface I3CourseQuizQuestionRepository extends JpaRepository<I3CourseQuizQuestion, Long>, JpaSpecificationExecutor<I3CourseQuizQuestion> {

}
