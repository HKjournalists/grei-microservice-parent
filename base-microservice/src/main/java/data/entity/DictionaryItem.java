package data.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 *  @author 刘佳兴
 */
@Data
@Entity
@Table(name = "pt_dict_item")
public class DictionaryItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "name", length = 60, nullable = false)
    protected String name;

    @Column(name = "nameen", length = 60, nullable = false)
    protected String nameEn;

    @Column(name = "code", length = 60, nullable = false)
    protected String code;

    @Column(name = "value", length = 60, nullable = false)
    protected String value;

    @Column(name = "status")
    protected Boolean status;           //1 启用 0 禁用

    @Column(name = "priority")
    protected Integer priority;

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

    @PrePersist
    public void created() {
        this.createTime = new Timestamp(new Date().getTime());
        this.updateTime = createTime;
    }

    @PreUpdate
    public void updated() {
        this.updateTime = new Timestamp(new Date().getTime());
        if(null == this.createTime) this.createTime = this.updateTime;
    }

}
