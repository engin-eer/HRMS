package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobseekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobseekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}


	@PostMapping("/add")
	public void add(@RequestBody JobSeeker jobseeker){
		this.jobSeekerService.add(jobseeker);
	}

	@PostMapping("/update")
	public void update(@RequestBody JobSeeker jobSeeker){
		this.jobSeekerService.update(jobSeeker);
	}

	@PostMapping("/delete")
	public void delete(@PathVariable("id") int id){
		this.jobSeekerService.delete(id);
	}

	@GetMapping("/getbyid")
	public JobSeeker getById(@PathVariable("id") int id){
		return this.jobSeekerService.getById(id);
	}

	@GetMapping("/getall")
	public List<JobSeeker> getAll(){
		return this.jobSeekerService.getAll();
	}

}
