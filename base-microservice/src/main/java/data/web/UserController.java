package data.web;

import data.entity.User;
import data.exception.APIException;
import data.helper.NullHelper;
import data.helper.ToolSecurityPbkdf2;
import data.query.QUser;
import data.repository.UserRepository;
import data.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

/**
 *
 * @author 刘佳兴
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    /**
     * 新增
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    User create(@RequestBody User user) {
        if(null != user.getId()) throw new APIException("request.data.valid.exists", new String[]{"User"});
        QUser qUser = new QUser();
        qUser.setEqualLoginName(user.getLoginName());
        if(null != userRepository.findOne(qUser)) throw new APIException("request.data.valid.exists", new String[]{"User's Login Name"});

        try {
            user.setSalt(ToolSecurityPbkdf2.generateSalt());
            user.setPassword(ToolSecurityPbkdf2.getEncryptedPassword("888888", user.getSalt()));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new APIException("base.user.password.initialization");
        }

        user.setCreateTime(new Date());
        return userRepository.save(user);
    }

    /**
     * 更新
     */
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.POST)
    User update(@RequestBody User user, @PathVariable Long userId) {
        User oldUser = userRepository.findOne(userId);
        BeanUtils.copyProperties(user, oldUser, NullHelper.getNullPropertyNames(user));
        return userRepository.save(oldUser);
    }

    /**
     * 查找
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    User findOne(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    Page<User> page(QUser qUser, Pageable pageable) {
        return userRepository.findAll(qUser, pageable);
    }

}
