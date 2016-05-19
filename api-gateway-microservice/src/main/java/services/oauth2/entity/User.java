package services.oauth2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统用户信息
 *
 * @author 刘佳兴
 */
@Data
@Entity
@Table(name = "pt_user")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "loginname")
    protected String loginName;

    @Column(name = "password")
    protected byte[] password;

    @Column(name = "salt")
    protected byte[] salt;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(User user) {
        super();
        this.id = user.getId();
        this.loginName = user.getLoginName();
        this.password = user.getPassword();
        this.salt = user.getSalt();
        this.roles = user.getRoles();
    }

}
