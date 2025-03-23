package com.PgManagement.Pg.user.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.PgManagement.Pg.user.entity.MstPg;

@Component
public interface PgService {

	MstPg createPG(MstPg pgdat);

	
}
