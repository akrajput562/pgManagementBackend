package com.PgManagement.Pg.user.serviceImp;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.PgManagement.Pg.user.dto.VAlidationPgCode;
import com.PgManagement.Pg.user.entity.MstTenant;
import com.PgManagement.Pg.user.repo.MstPgRepo;
import com.PgManagement.Pg.user.repo.TenantRepo;
import com.PgManagement.Pg.user.service.TenantsService;

@Component
public class TenantsServiceImpl implements TenantsService{
@Autowired MstPgRepo mstPgRepo;
@Autowired TenantRepo tenantRepo;
private final String FOLDER_PATH="D:\\tenant_file\\";

	
	@Override
	public Boolean isVAlidationPgCode(VAlidationPgCode code) {
		String flag=mstPgRepo.getPgCodeByPgId(code.getPgCode());
		if(flag.equals("Y"))return true;
		return false;
		
	}
	@Override
	 public String uploadImageToFileSystem(MstTenant bo) throws IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String safeDate = sdf.format(new Date());
	        String filePath=FOLDER_PATH+"ahara_"+bo.getName()+safeDate+".png";
	        String filePath1=FOLDER_PATH+"company_"+bo.getName()+safeDate+".png";


	        bo.setAdharCardFolder("ahara_"+bo.getName()+safeDate);
	        bo.setCompanyIdFolder("company_"+bo.getName()+safeDate);
	        MstTenant save = tenantRepo.save(bo);
	        if(save.getTenant_id()!=null){
	        	 bo.getAdharCard().transferTo(new File(filePath));
	        	 bo.getCompanyId().transferTo(new File(filePath1));
	        }
	       
	        return null;
	    }


}
