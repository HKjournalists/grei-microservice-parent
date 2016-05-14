package data.repository;

import data.entity.I3Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * i3 course repository Created by 刘佳兴 on 16-3-17.
 */
@Repository
public interface I3CourseRepository extends JpaRepository<I3Course, Long>, JpaSpecificationExecutor<I3Course> {

}
