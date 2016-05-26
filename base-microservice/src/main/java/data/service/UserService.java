package data.service;

import data.entity.User;
import data.query.QUser;
import data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

/**
 * @author 刘佳兴
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void existLoginName(String loginName) {
        QUser qUser = new QUser();
        qUser.setEqualLoginName(loginName);
        if(null != userRepository.findOne(qUser)) throw new RuntimeException("登录名已存在!");
    }


}
