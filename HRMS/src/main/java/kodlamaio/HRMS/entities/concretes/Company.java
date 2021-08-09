package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="companies")
@Data
public class Company {
	
	@Id
	@GeneratedValue
	@Column(name= "id")
	private int id;

	@Column(name = "company_name")
	private String companyName;

	public Company(String companyName) {
		super();
		this.companyName = companyName;
	}

}
