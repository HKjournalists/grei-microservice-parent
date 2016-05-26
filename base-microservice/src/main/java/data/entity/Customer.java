package data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户信息
 */
@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(name = "code")
	protected String code;

	@Column(name = "country")
	protected String country;

	@Column(name = "internationalcode")
	protected String countryPhoneCode;

	@Column(name = "telephone")
	protected String mobilePhone;

	@Column(name = "invitecode")
	protected String invitecode;

	@JsonIgnore
	@Column(name = "password")
	protected byte[] password;

	@JsonIgnore
	@Column(name = "salt")
	protected byte[] salt;

	@Column(name = "firstname")
	protected String firstname;

	@Column(name = "middlename")
	protected String middlename;

	@Column(name = "lastname")
	protected String lastname;

	@Column(name = "star")
	protected BigDecimal star;

	@Column(name = "organizationid")
	protected Long organizationid;

	@Column(name = "email")
	protected String email;

	@Column(name = "roleid")
	protected Integer roleid;

	@Column(name = "rolerankid")
	protected Integer rolerankid;

	@Column(name = "recommendid")
	protected Long recommendid;

	@Column(name = "gender")
	protected String gender;

	@Column(name = "commission")
	protected Integer commission;

	@Column(name = "username")
	protected String username;

	@Column(name = "status")
	protected String status;

	@Column(name = "authenticationstatus")
	protected Long authenticationstatus;

	@Column(name = "errorcount")
	protected Long errorcount;

	@Column(name = "stopdate")
	protected Integer stopdate;

	@Column(name = "createdate")
	protected Date createdate;

	@Column(name = "createby")
	protected long createby;

	@Column(name = "modifydate")
	protected Date modifydate;

	@Column(name = "modifyby")
	protected long modifyby;

	@Column(name = "regtime")
	protected Date regtime;

	@Column(name = "confirmdate")
	protected Date confirmdate;

	@Column(name = "profile")
	protected String profile;

	@Column(name = "aboutme")
	protected String aboutme;

	@Column(name = "nickname")
	protected String nickname;

	@Column(name = "lastlogintime")
	protected Date lastlogintime;

	@Column(name = "grade")
	protected String grade;

	@Column(name = "foreignInvestors")
	protected String foreignInvestors;

	@Column(name = "paypal")
	protected String paypal;

	@Column(name = "abn")
	protected String abn;

	@Column(name = "birthday")
	protected Date birthday;

	@Column(name = "language")
	protected String language;

	@Column(name = "currentindustry")
	protected String currentindustry;

	@Column(name = "tfn")
	protected String tfn;

	@Column(name = "receivecheque")
	protected String receivecheque;

	@Column(name = "writecheque")
	protected String writecheque;

	@Column(name = "invitesum")
	protected Integer inviteSum;

	@Column(name = "review")
	protected Integer review;

	@Column(name = "showname")
	protected String showname;

	@Column(name = "recommendstatus")
	protected String recommendstatus;

	@Column(name = "jpushpwd")
	protected String jpushpwd;

}
