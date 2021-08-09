package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.entities.concretes.JobPosition;

public interface JobPositionService {
	
	void add(JobPosition jobPosition);
	void update(JobPosition jobPosition);
	void delete(int id);
	JobPosition getById(int id);
	List<JobPosition> getAll();

}