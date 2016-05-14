package data.repository;


import data.entity.I3CourseQuizTake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * i3 course quiz
 * Created by 刘佳兴 on 16-4-26.
 */
@Repository
public interface I3CourseQuizTakeRepository extends JpaRepository<I3CourseQuizTake, Long>, JpaSpecificationExecutor<I3CourseQuizTake> {

}
