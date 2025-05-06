package com.PgManagement.Pg.user.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.PgManagement.Pg.user.dto.CheckExistingTenant;
import com.PgManagement.Pg.user.dto.VAlidationPgCode;
import com.PgManagement.Pg.user.entity.MstTenant;
import com.PgManagement.Pg.user.entity.RentInfo;
import com.PgManagement.Pg.user.entity.MstTenantRequest;

@Component
public interface TenantsService {

	Map<String, Object> isVAlidationPgCode(VAlidationPgCode code);

	String uploadImageToFileSystem(MstTenantRequest bo) throws IOException;

	byte[] downloadImageFromFileSystem(long fileName) throws IOException;

	RentInfo saveRent(RentInfo bo);

	String updateAgreementInfo(Long reqId, MstTenantRequest agreementData);

	String checkExistingUser(CheckExistingTenant checkExisistingTenantDto);

}
