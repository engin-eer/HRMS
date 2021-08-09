package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.HRMS.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public void add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
	}

	@Override
	public void update(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
	}

	@Override
	public void delete(int id) {
		this.jobSeekerDao.deleteById(id);;
	}

	@Override
	public JobSeeker getById(int id) {
		return this.jobSeekerDao.getOne(id);
	}

	@Override
	public List<JobSeeker> getAll() {
		return this.jobSeekerDao.findAll();
	}

}
