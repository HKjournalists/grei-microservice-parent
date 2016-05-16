package data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 刘佳兴
 */
@Data
@Entity
@Table(name = "i3_course_lesson_slide")
public class CourseLessonSlide {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "courseid", nullable = false)
    protected Long courseid;

    @Column(name = "lessonid", nullable = false)
    protected Long lessonid;

    @Column(name = "url", nullable = false, length = 255)
    protected String url;

    @Column(name = "createddtm", nullable = false)
    protected Date createddtm;

}
