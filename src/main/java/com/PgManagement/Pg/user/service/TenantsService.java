package com.PgManagement.Pg.user.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.PgManagement.Pg.user.dto.VAlidationPgCode;
import com.PgManagement.Pg.user.entity.MstTenant;
import com.PgManagement.Pg.user.entity.MstTenantRequest;

@Component
public interface TenantsService {

	Map<String, Object> isVAlidationPgCode(VAlidationPgCode code);

	String uploadImageToFileSystem(MstTenantRequest bo) throws IOException;

}
