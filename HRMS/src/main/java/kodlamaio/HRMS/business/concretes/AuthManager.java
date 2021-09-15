package kodlamaio.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.AuthService;
import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.core.utilities.adapters.ValidationService;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.core.utilities.verification.VerificationService;
import kodlamaio.HRMS.entities.concretes.Employer;
import kodlamaio.HRMS.entities.concretes.JobSeeker;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private EmployerService employerService;
	private JobSeekerService jobSeekerService;
	private VerificationService verificationService;
	private ValidationService validationService;

	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, JobSeekerService jobSeekerService, VerificationService verificationService, ValidationService validationService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.jobSeekerService = jobSeekerService;
		this.verificationService = verificationService;
		this.validationService = validationService;
	}

	@Override
	public Result registerEmployer(Employer employer) {

		if (!checkIfNullInfoForEmployer(employer)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebsite())) {

			return new ErrorResult("Invalid email address.");
		}

		if (!checkIfEmailExists(employer.getEmail())) {

			return new ErrorResult(employer.getEmail() + " already exists.");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), employer.getConfirmPassword())) {

			return new ErrorResult("Passwords do not match.");
		}

		verificationService.sendLink(employer.getEmail());
		employerService.add(employer);

		return new SuccessResult("Registration has been successfully completed");

	}

	@Override
	public Result registerJobSeeker(JobSeeker jobSeeker) {
		
		if (checkIfRealPerson(Long.parseLong(jobSeeker.getNationalId()), jobSeeker.getFirstName(),
				jobSeeker.getLastName(), jobSeeker.getDateOfBirth().getYear()) == false) {
			return new ErrorResult("TCKN could not be verified.");
		}



		if (!checkIfNullInfoForJobSeeker(jobSeeker)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfExistsTcNo(jobSeeker.getNationalId())) {

			return new ErrorResult(jobSeeker.getNationalId() + " already exists.");
		}

		if (!checkIfEmailExists(jobSeeker.getEmail())) {

			return new ErrorResult(jobSeeker.getEmail() + " already exists.");
		}
		
		verificationService.sendLink(jobSeeker.getEmail());
		jobSeekerService.add(jobSeeker);
		return new SuccessResult("Registration has been successfully completed");
	}

	// Validation for employer register ---START---

	private boolean checkIfNullInfoForEmployer(Employer employer) {

		if (employer.getCompanyName() != null && employer.getWebsite() != null && employer.getEmail() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null
				&& employer.getConfirmPassword() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}


	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}

	// Validation for employer register ---END---

	// Validation for jobSeeker register ---START---
	private boolean checkIfNullInfoForJobSeeker(JobSeeker jobSeeker) {

		if (jobSeeker.getFirstName() != null && jobSeeker.getLastName() != null && jobSeeker.getNationalId() != null
				&& jobSeeker.getDateOfBirth() != null && jobSeeker.getPassword() != null
				&& jobSeeker.getConfirmPassword() != null && jobSeeker.getEmail() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfExistsTcNo(String nationalId) {

		if(this.jobSeekerService.getJobSeekerByNationalId(nationalId).getData() == null ) {
			return true;
		}
		return false;
	}

	// Validation for jobSeeker register ---END---

	// Common Validation


	private boolean checkIfEmailExists(String email) {

		if (this.userService.getUserByEmail(email).getData() == null) {

			return true;
		}

		return false;
	}
	
	private boolean checkIfRealPerson(long nationalId, String firstName, String lastName, int yearOfBirth) {

		if (validationService.validateByMernis(nationalId, firstName, lastName, yearOfBirth)) {
			return true;
		}
		return false;
	}
}