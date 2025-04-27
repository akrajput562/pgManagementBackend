package com.PgManagement.Pg.user.service;

import java.io.IOException;

import org.springframework.stereotype.Component;
import com.PgManagement.Pg.user.dto.VAlidationPgCode;
import com.PgManagement.Pg.user.entity.MstTenant;

@Component
public interface TenantsService {

	Boolean isVAlidationPgCode(VAlidationPgCode code);

	String uploadImageToFileSystem(MstTenant bo) throws IOException;

}
