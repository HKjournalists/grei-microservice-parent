package data.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@Data
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @Column(name = "projectname")
    protected String projectName;


}
