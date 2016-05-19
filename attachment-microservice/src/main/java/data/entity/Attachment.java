package data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘佳兴
 */
@Data
@Entity
@Table(name = "attachment")
@EqualsAndHashCode(callSuper = true)
public class Attachment extends BaseEntity {

    //UUID名称
    protected String name;

    //真实名称
    protected String realName;

    //上传的相对路径
    protected String relativePath;

    //文件类型
    @Column(length = 30)
    protected String contentType;

    //文件大小
    protected  Long size;

    @Transient
    protected String url;

    public Attachment() {

    }

    public Attachment(String name, String realName, String relativePath, String contentType, Long size) {
        this.name = name;
        this.realName = realName;
        this.relativePath = relativePath;
        this.contentType = contentType;
        this.size = size;
    }
}
