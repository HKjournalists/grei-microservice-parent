package data.repository;


import data.entity.I3CourseQuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * i3 course quiz answer
 * Created by 刘佳兴 on 16-4-26.
 */
@Repository
public interface I3CourseQuizAnswerRepository extends JpaRepository<I3CourseQuizAnswer, Long>, JpaSpecificationExecutor<I3CourseQuizAnswer> {

}
