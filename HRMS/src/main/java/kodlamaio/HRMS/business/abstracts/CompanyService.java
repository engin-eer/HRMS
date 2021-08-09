package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.entities.concretes.Company;

public interface CompanyService {
	
	void add(Company company);
	void update(Company company);
	void delete(int id);
	Company getById(int id);
	List<Company> getAll();

}
