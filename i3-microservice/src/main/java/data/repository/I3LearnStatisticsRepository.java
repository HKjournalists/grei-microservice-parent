package data.repository;


import data.entity.I3LearnStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * i3 learn statistics repository
 * Created by 刘佳兴 on 16-3-25.
 */
@Repository
public interface I3LearnStatisticsRepository extends JpaRepository<I3LearnStatistics, Long>, JpaSpecificationExecutor<I3LearnStatistics> {

}
