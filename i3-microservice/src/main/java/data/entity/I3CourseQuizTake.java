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
@Table(name = "i3_course_quiz_take")
public class I3CourseQuizTake {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(name = "courseid")
	protected Long courseId;

	@Column(name = "quizid")
	protected Long quizId;

	@Column(name = "userid")
	protected Long userId;

	@Column(name = "datasourceid")
	protected Long datasourceId;

	@Column(name = "total")
	protected Integer total;

	@Column(name = "answered")
	protected Integer answered;

	@Column(name = "[right]")
	protected Integer right;

	@Column(name = "finished")
	protected Boolean finished;

	@Column(name = "updatedby")
	protected Long updatedby;

	@Column(name = "updateddtm")
	protected Date updateddtm;

}
