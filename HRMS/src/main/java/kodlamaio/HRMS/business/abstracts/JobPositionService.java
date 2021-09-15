package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobPosition;

public interface JobPositionService {
	
	Result add(JobPosition jobPosition);
	Result update(JobPosition jobPosition);
	Result delete(int id);
	DataResult<JobPosition> getById(int id);
	DataResult<List<JobPosition>> getAll();
	DataResult<JobPosition> getJobByTitle(String title);

}
