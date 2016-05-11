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
@Table(name = "i3_learn_history")
public class I3LearnHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Basic
    @Column(name = "customerid")
    protected Long customerid;

    @Basic
    @Column(name = "courseid")
    protected Long courseid;

    @Basic
    @Column(name = "lessonid")
    protected Long lessonid;

    @Basic
    @Column(name = "datasourceid")
    protected Long datasourceid;

    @Basic
    @Column(name = "updateddtm")
    protected Date updateddtm;

}
