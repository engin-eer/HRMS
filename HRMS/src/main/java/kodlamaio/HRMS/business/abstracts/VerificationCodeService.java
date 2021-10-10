package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	
	Result add(VerificationCode code);
//	Result delete(VerificationCode code);
//	Result update(VerificationCode code);
//
//    DataResult<VerificationCode> getById(int id);
//	DataResult<List<VerificationCode>> getAll();

}
