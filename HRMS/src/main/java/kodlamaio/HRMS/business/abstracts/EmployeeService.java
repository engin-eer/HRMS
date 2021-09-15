 package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Employee;

public interface EmployeeService {
	
	Result add(Employee employee);
	Result update(Employee employee);
	Result delete(int id);
	DataResult<Employee> getById(int id);
	DataResult<List<Employee>> getAll();

}
