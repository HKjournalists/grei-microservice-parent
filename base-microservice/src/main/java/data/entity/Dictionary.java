package data.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 *  @author 刘佳兴
 */
@Data
@Entity
@Table(name = "pt_dict")
public class Dictionary {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    @Column(name = "name", length = 60, nullable = false)
    protected String name;

    @NotNull
    @Column(name = "code", length = 60, nullable = false)
    protected String code;

    @Column(name = "remark", length = 300)
    protected String remark;

    @Column(name = "createtime")
    protected Timestamp createTime;

    @Column(name = "updatetime")
    protected Timestamp updateTime;

    @Column(name = "createby")
    protected Long createBy;

    @Column(name = "updateby")
    protected Long updateBy;

    @Transient
    List<DictionaryItem> dictionaryItems = new ArrayList<>();

}
