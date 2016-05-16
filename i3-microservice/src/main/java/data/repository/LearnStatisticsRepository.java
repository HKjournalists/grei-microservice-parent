package data.repository;


import data.entity.LearnStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * i3 learn statistics repository
 * Created by 刘佳兴 on 16-3-25.
 */
@Repository
public interface LearnStatisticsRepository extends JpaRepository<LearnStatistics, Long>, JpaSpecificationExecutor<LearnStatistics> {

}
