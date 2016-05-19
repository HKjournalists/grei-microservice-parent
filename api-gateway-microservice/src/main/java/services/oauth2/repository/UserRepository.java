package services.oauth2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import services.oauth2.entity.User;

/**
 *
 * @author 刘佳兴
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByLoginName(String loginName);

}
