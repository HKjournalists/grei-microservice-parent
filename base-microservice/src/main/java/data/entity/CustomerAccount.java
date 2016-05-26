package data.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户账户信息
 */
@Data
@Entity
@Table(name = "customer_account")
public class CustomerAccount {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "customerid")
    private Long customerid;

    @Column(name = "actype")
    private String actype;

    @Column(name = "currency")
    private String currency;

    @Column(name = "baldbcr")
    private String baldbcr;

    @Column(name = "usablebalance")
    private BigDecimal usablebalance;

    @Column(name = "minstlbalance")
    private BigDecimal minstlbalance;

    @Column(name = "frozenbalance")
    private BigDecimal frozenbalance;

    @Column(name = "status")
    private String status;

    @Column(name = "lasttxtime")
    private Date lasttxtime;

    @Column(name = "createtime")
    private Date createtime;

    @Column(name = "createby")
    private Long createby;

    @Column(name = "updatetime")
    private Date updatetime;

    @Column(name = "updateby")
    private Long updateby;
    
}
