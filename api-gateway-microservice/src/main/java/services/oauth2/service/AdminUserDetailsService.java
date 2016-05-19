package services.oauth2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import services.oauth2.entity.AdminUserDetails;
import services.oauth2.entity.User;
import services.oauth2.repository.UserRepository;

/**
 * 请求用户信息类
 *
 * @author 刘佳兴
 */
@Service
public class AdminUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLoginName(username);
        if(null == user) throw new UsernameNotFoundException(String.format("User %s does not exist!", username));

        return new AdminUserDetails(user);
    }

}
