package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.User;

public interface UserService {
	
	Result add(User user);
	Result update(User user);
	Result delete(int id);
	DataResult<User> getById(int id);
	DataResult<List<User>> getAll();
	DataResult<User> getUserByEmail(String email);
}
