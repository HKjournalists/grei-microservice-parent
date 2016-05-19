package data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 刘佳兴
 */
@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @Column(nullable = false)
    protected Long createdBy = 0L;

    @Column(nullable = false)
    protected Date createdAt;

    @Column(nullable = false)
    protected Long updatedBy = 0L;

    @Column(nullable = false)
    protected Date updatedAt;

    //逻辑删除操作，子类需要添加: @where(clause="deleted=0")
    @Column(nullable = false)
    protected Boolean deleted = false;

    @PrePersist
    public void created() {
        this.createdAt = new Date();
        this.updatedAt = createdAt;
    }

    @PreUpdate
    public void updated() {
        this.updatedAt = new Date();
    }

    @JsonIgnore
    public Boolean isNew() {
        return id == null;
    }

}
