package com.PgManagement.Pg.user.service;

import java.io.IOException;

import org.springframework.stereotype.Component;
import com.PgManagement.Pg.user.dto.VAlidationPgCode;
import com.PgManagement.Pg.user.entity.MstTenant;
import com.PgManagement.Pg.user.entity.RentInfo;

@Component
public interface TenantsService {

	Boolean isVAlidationPgCode(VAlidationPgCode code);

	String uploadImageToFileSystem(MstTenant bo) throws IOException;

	byte[] downloadImageFromFileSystem(long fileName) throws IOException;

	String saveRent(RentInfo bo);

}
