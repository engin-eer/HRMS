package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMS.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public void add(Employer employer) {
		this.employerDao.save(employer);
	}

	@Override
	public void update(Employer employer) {
		this.employerDao.save(employer);
	}

	@Override
	public void delete(int id) {
		this.employerDao.deleteById(id);;
	}

	@Override
	public Employer getById(int id) {
		return this.employerDao.getOne(id);
	}

	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

}