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
@Table(name = "i3_course_quiz_answer")
public class I3CourseQuizAnswer {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(name = "takeid")
	protected Long takeId;

	@Column(name = "quizid")
	protected Long quizId;

	@Column(name = "questionid")
	protected Long questionId;

	@Column(name = "optionid")
	protected Long optionId;

	@Column(name = "datasourceid")
	protected Long datasourceId;

	@Column(name = "sequence")
	protected Integer sequence;

	@Column(name = "[right]")
	protected Boolean right;

	@Column(name = "checked")
	protected Boolean checked;

	@Column(name = "answerdtm")
	protected Date answerdtm;

}
