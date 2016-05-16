package data.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 刘佳兴

 */
@Data
@Entity
@Table(name = "i3_course_quiz")
public class CourseQuiz {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "courseid")
    protected Long courseId;

    @Column(name = "sequence")
    protected Integer sequence;

    @Column(name = "name")
    protected String name;

}
