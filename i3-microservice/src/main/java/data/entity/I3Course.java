package data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@Data
@Entity
@Table(name = "i3_course")
public class I3Course implements Serializable {

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
	protected Integer posted;

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
