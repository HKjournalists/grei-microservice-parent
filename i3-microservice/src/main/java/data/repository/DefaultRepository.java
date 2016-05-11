package data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;


/**
 * default repository interface
 * Created by 刘佳兴 on 16-3-17.
 */
@NoRepositoryBean
public interface DefaultRepository<T> extends JpaRepository<T, Long>,
		JpaSpecificationExecutor<T> {

}
