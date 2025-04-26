package com.PgManagement.Pg.user.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.PgManagement.Pg.user.dto.VAlidationPgCode;
import com.PgManagement.Pg.user.repo.MstPgRepo;
import com.PgManagement.Pg.user.service.TenantsService;

@Component
public class TenantsServiceImpl implements TenantsService{
@Autowired MstPgRepo mstPgRepo;
	
	@Override
	public Boolean isVAlidationPgCode(VAlidationPgCode code) {
		String flag=mstPgRepo.getPgCodeByPgId(code.getPgCode());
		if(flag.equals("Y"))return true;
		return false;
		
	}

}
