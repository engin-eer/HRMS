package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.entities.concretes.User;

public interface UserService {
	
	void add(User user);
	void update(User user);
	void delete(int id);
	User getById(int id);
	List<User> getAll();

}
