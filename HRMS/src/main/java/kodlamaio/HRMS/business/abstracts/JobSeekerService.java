package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	void add(JobSeeker jobSeeker);
	void update(JobSeeker jobSeeker);
	void delete(int id);
	JobSeeker getById(int id);
	List<JobSeeker> getAll();

}
