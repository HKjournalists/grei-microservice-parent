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
@Table(name = "i3_learn_statistics")
public class I3LearnStatistics {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Basic
    @Column(name = "customerid")
    protected Long customerid;

    @Basic
    @Column(name = "lessons")
    protected Integer lessons;

    @Basic
    @Column(name = "level")
    protected Integer level;

    @Basic
    @Column(name = "updateddtm")
    protected Date updateddtm;

}
