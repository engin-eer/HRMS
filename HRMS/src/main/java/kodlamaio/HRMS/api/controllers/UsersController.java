package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}


	@PostMapping("/add")
	public Result add(@RequestBody User user){
		return this.userService.add(user);
	}

	@PostMapping("/update")
	public Result update(@RequestBody User user){
		return this.userService.update(user);
	}

	@PostMapping("/delete")
	public Result delete(@PathVariable("id") int id){
		return this.userService.delete(id);
	}

	@GetMapping("/getbyid")
	public DataResult<User> getById(@PathVariable("id") int id){
		return this.userService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}

}

