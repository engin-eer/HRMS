package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobSeeker;
import kodlamaio.HRMS.entities.concretes.User;

public interface JobSeekerService {
	
	Result add(JobSeeker jobSeeker);
	Result update(JobSeeker jobSeeker);
	Result delete(int id);
	DataResult<JobSeeker> getById(int id);
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> getJobSeekerByNationalId(String nationalId);

}
