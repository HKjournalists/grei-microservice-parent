package data.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@Data
@Entity
@Table(name = "i3_course_lesson")
public class I3CourseLesson implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "courseid")
    protected Long courseid;

    @Column(name = "sequence")
    protected Integer sequence;

    @Column(name = "cover")
    protected String cover;

    @Column(name = "type")
    protected Integer type;

    @Column(name = "name")
    protected String name;

    @Column(name = "length")
    protected Integer length;

    @Column(name = "sourceurl")
    protected String sourceurl;

    @Column(name = "content")
    protected String content;

}
