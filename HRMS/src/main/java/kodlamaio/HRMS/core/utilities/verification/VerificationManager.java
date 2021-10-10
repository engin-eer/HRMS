package kodlamaio.HRMS.core.utilities.verification;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.HRMS.entities.concretes.VerificationCode;

@Service
public class VerificationManager implements VerificationService{
	
//	private VerificationCodeDao verificationCodeDao;
//
//	@Autowired
//	public VerificationManager(VerificationCodeDao verificationCodeDao) {
//		super();
//		this.verificationCodeDao = verificationCodeDao;
//	}


	
	@Override
	public void sendLink(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://hrmsverificationmail/" + uuid.toString();
		System.out.println("Verification link has been sent to " + email );
		System.out.println("Please click on the link to verify your account:  " + verificationLink );
	}

	@Override
	public String sendCode() {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		
		System.out.println("Your activation code:  " + verificationCode );
		return verificationCode;
	}



}
