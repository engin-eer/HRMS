package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.entities.concretes.Department;

public interface DepartmentService {
	void add(Department department);
	void update(Department department);
	void delete(int id);
	Department getById(int id);
	List<Department> getAll();

}
