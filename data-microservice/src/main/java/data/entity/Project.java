package data.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@Entity
@Table(name = "project")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @Column(name = "projectname")
    protected String projectName;


}
