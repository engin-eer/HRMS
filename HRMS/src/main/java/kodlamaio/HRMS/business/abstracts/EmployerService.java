package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Employer;

public interface EmployerService {
	
	Result add(Employer employer);
	Result update(Employer employer);
	Result delete(int id);
	DataResult<Employer> getById(int id);
	DataResult<List<Employer>> getAll();

}
