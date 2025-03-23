package com.PgManagement.Pg.user.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PgManagement.Pg.user.entity.MstPg;
import com.PgManagement.Pg.user.repo.MstPgRepo;
import com.PgManagement.Pg.user.service.PgService;

@Service
public class PgServiceImpl implements PgService{

	@Autowired MstPgRepo pgDataRepo;
	
	@Override
	public MstPg createPG(MstPg pgdat) {
		return pgDataRepo.save(pgdat);
	}

}
