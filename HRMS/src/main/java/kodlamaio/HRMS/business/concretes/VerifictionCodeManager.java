package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.HRMS.business.abstracts.VerificationCodeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.HRMS.entities.concretes.VerificationCode;

public class VerifictionCodeManager implements VerificationCodeService{
	
	private VerificationCodeDao verificationCodeDao;

	@Autowired
	public VerifictionCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(VerificationCode code) {
		this.verificationCodeDao.save(code);
		return new SuccessResult("Code has been saved.");
	}

//	@Override
//	public Result delete(VerificationCode code) {
//		this.verificationCodeDao.delete(code);
//		return new SuccessResult("Code has been deleted.");
//	}
//
//	@Override
//	public Result update(VerificationCode code) {
//		this.verificationCodeDao.save(code);
//		return new SuccessResult("Code has been updated.");
//	}
//
//	@Override
//	public DataResult<VerificationCode> getById(int id) {
//		return new SuccessDataResult<VerificationCode>(this.verificationCodeDao.getOne(id));
//	}
//
//	@Override
//	public DataResult<List<VerificationCode>> getAll() {
//		return new SuccessDataResult<List<VerificationCode>>(this.verificationCodeDao.findAll());
//	}



}
