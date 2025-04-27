package com.PgManagement.Pg.user.serviceImp;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.PgManagement.Pg.user.dto.VAlidationPgCode;
import com.PgManagement.Pg.user.entity.MstTenant;
import com.PgManagement.Pg.user.repo.MstPgRepo;
import com.PgManagement.Pg.user.repo.TenantRepo;
import com.PgManagement.Pg.user.service.TenantsService;
import com.PgManagement.Pg.util.CommonService;

@Component
public class TenantsServiceImpl implements TenantsService{
@Autowired MstPgRepo mstPgRepo;
@Autowired TenantRepo tenantRepo;
@Autowired CommonService commonService;

	
	@Override
	public Boolean isVAlidationPgCode(VAlidationPgCode code) {
		String flag=mstPgRepo.getPgCodeByPgId(code.getPgCode());
		if(flag.equals("Y"))return true;
		return false;
		
	}
	
	@Override
	 public String uploadImageToFileSystem(MstTenant bo) throws IOException {
		String adharFolder="";
		String companyFolder="";
		if(bo.getAdharCard().getOriginalFilename()!=null || bo.getCompanyId().getOriginalFilename()!=null) {
			
			 adharFolder = commonService.uploadImage(bo.getAdharCard());
        	 companyFolder = commonService.uploadImage(bo.getCompanyId());
			
		}
			bo.setAdharCardFolder(adharFolder);
	        bo.setCompanyIdFolder(companyFolder);
	        tenantRepo.save(bo);
	        
	       
	        return null;
	    }
	


}
