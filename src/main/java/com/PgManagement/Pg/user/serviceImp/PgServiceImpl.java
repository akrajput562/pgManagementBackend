package com.PgManagement.Pg.user.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PgManagement.Pg.user.entity.PgData;
import com.PgManagement.Pg.user.repo.PgDataRepo;
import com.PgManagement.Pg.user.service.PgService;

@Service
public class PgServiceImpl implements PgService{

	@Autowired PgDataRepo pgDataRepo;
	
	@Override
	public PgData createPG(PgData pgdat) {
		return pgDataRepo.save(pgdat);
	}

}
