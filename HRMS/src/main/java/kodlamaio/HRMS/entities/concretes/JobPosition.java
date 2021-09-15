package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_positions")
@Data
public class JobPosition {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name= "created_at", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate createdDate = LocalDate.now();
	
	@Column(name= "is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;
	
	@Column(name= "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;


}
