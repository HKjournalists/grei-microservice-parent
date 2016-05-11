package data.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@Data
@Entity
@Table(name = "i3_course_quiz_option")
public class I3CourseQuizOption {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "courseid")
    protected Long courseId;

    @Column(name = "quizid")
    protected Long quizId;

    @Column(name = "questionid")
    protected Long questionId;

    @Column(name = "name")
    protected String name;

    @Column(name = "[right]")
    protected Boolean right;

}
