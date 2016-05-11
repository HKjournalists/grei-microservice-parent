package data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@Data
@Entity
@Table(name = "i3_course_lesson_slide")
public class I3CourseLessonSlide {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "courseid", nullable = false)
    private Long courseid;

    @Column(name = "lessonid", nullable = false)
    private Long lessonid;

    @Column(name = "url", nullable = false, length = 255)
    private String url;

    @Column(name = "createddtm", nullable = false)
    private Date createddtm;

}
