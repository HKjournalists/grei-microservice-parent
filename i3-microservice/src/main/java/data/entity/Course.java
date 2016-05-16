package data.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 课程实体类
 *
 * @author 刘佳兴
 * @see java.io.Serializable
 */
@Data
@Entity
@Table(name = "i3_course")
public class Course implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(name = "name")
	protected String name;

	@Column(name = "category")
	protected Integer category;

	@Column(name = "subcategory")
	protected Integer subcategory;

	@Column(name = "description")
	protected String description;

	@Column(name = "cover")
	protected String cover;

	@Column(name = "language")
	protected Integer language;

	@Column(name = "difficulty")
	protected String difficulty;

	@Column(name = "posted")
	protected Boolean posted;

	@Column(name = "length")
	protected Integer length;

	@Column(name = "createdby")
	protected Long createdby;

	@Column(name = "createddtm")
	protected Date createddtm;

	@Column(name = "updatedby")
	protected Long updatedby;

	@Column(name = "updateddtm")
	protected Date updateddtm;

	@Column(name = "version")
	protected Integer version;

}
