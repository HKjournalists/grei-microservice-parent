package data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@Data
@Entity
@Table(name = "i3_search_history")
public class I3SearchHistory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    @Column(name = "customerid")
    private long customerid;

    @Basic
    @Column(name = "key")
    private String key;

    @Basic
    @Column(name = "datasourceid")
    private Long datasourceid;

    @Basic
    @Column(name = "updateddtm")
    private Date updateddtm;

}
