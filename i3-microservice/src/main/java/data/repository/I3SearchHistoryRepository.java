package data.repository;

import data.entity.I3SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * i3 learn repository
 * Created by 刘佳兴 on 16-3-25.
 */
@Repository
public interface I3SearchHistoryRepository extends JpaRepository<I3SearchHistory, Long>, JpaSpecificationExecutor<I3SearchHistory> {

}
