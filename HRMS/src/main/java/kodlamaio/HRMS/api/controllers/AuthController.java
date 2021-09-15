package kodlamaio.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.AuthService;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Employer;
import kodlamaio.HRMS.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/registerEmployer")
	public Result registerEmpolyer(@RequestBody Employer employer)
	{
		return authService.registerEmployer(employer);
	}

	@PostMapping("/registerJobseeker")
	public Result registerJobSeeker(@RequestBody JobSeeker jobSeeker)
	{
		return authService.registerJobSeeker(jobSeeker);
	}
}
