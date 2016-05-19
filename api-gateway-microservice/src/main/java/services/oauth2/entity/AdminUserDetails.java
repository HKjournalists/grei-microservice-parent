package services.oauth2.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import services.oauth2.entity.User;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author 刘佳兴
 */
public class AdminUserDetails implements UserDetails {

    private User user = null;

    public AdminUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles();
    }

    @Override
    public String getUsername() {
        return user.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return Arrays.toString(user.getPassword());
    }

    public byte[] getSalt() {
        return user.getSalt();
    }

}
