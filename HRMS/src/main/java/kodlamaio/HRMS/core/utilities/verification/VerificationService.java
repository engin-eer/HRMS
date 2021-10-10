package kodlamaio.HRMS.core.utilities.verification;

public interface VerificationService {
	
	void sendLink(String email);
	String sendCode();
	
}
