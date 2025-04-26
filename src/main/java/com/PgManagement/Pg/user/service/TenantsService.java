package com.PgManagement.Pg.user.service;

import org.springframework.stereotype.Component;

import com.PgManagement.Pg.user.dto.VAlidationPgCode;

@Component
public interface TenantsService {

	Boolean isVAlidationPgCode(VAlidationPgCode code);

}
