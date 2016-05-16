package data.repository;


import data.entity.CourseQuizOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * i3 course quiz option Created by 刘佳兴 on 16-4-26.
 */
@Repository
public interface CourseQuizOptionRepository extends JpaRepository<CourseQuizOption, Long>, JpaSpecificationExecutor<CourseQuizOption> {

}
