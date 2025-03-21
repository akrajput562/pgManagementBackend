package com.PgManagement.Pg.user.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.PgManagement.Pg.user.entity.PgData;

@Component
public interface PgService {

	PgData createPG(PgData pgdat);

	
}
