package data.repository;

import data.entity.CustomerDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 刘佳兴
 */
public interface CustomerDeveloperRepository extends JpaRepository<CustomerDeveloper, Long>, JpaSpecificationExecutor<CustomerDeveloper> {
    
}
