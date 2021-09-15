package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Employer;
import kodlamaio.HRMS.entities.concretes.JobSeeker;

public interface AuthService {

	Result registerEmployer(Employer employer);
	Result registerJobSeeker(JobSeeker jobSeeker);
}
