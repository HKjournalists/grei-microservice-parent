package data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 后台用户信息
 *
 * @author 刘佳兴
 */
@Data
@Entity
@Table(name = "pt_user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    @Column(name = "loginname")
    protected String loginName;

    @NotNull
    @Column(name = "fullname")
    protected String fullName;

    @JsonIgnore
    @Column(name = "password")
    protected byte[] password;

    @JsonIgnore
    @Column(name = "salt")
    protected byte[] salt;

    @Column(name = "email")
    protected String email;

    @Column(name = "phone")
    protected String phone;

    @Column(name = "status")
    protected Boolean status;

    @Column(name = "stopdate")
    protected Date stopDate;

    @Column(name = "errorcount")
    protected Integer errorCount;

    @Column(name = "lastlogintime")
    protected Date lastLoginTime;

    @Column(name = "createby")
    protected Long createBy;

    @Column(name = "createtime")
    protected Date createTime;

    @Column(name = "updateby")
    protected Date updateBy;

    @Column(name = "updatetime")
    protected Long updateTime;

}
