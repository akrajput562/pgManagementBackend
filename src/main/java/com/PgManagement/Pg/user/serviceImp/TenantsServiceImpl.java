package com.PgManagement.Pg.user.serviceImp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.PgManagement.Pg.user.dto.VAlidationPgCode;
import com.PgManagement.Pg.user.entity.MstTenant;
import com.PgManagement.Pg.user.entity.RentInfo;
import com.PgManagement.Pg.user.repo.MstPgRepo;
import com.PgManagement.Pg.user.repo.RentInfoRepo;
import com.PgManagement.Pg.user.repo.TenantRepo;
import com.PgManagement.Pg.user.service.TenantsService;
import com.PgManagement.Pg.util.CommonService;

@Component
public class TenantsServiceImpl implements TenantsService{
@Autowired MstPgRepo mstPgRepo;
@Autowired TenantRepo tenantRepo;
@Autowired CommonService commonService;
@Autowired RentInfoRepo rentInfoRepo;

	
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
	
	@Override
	public byte[] downloadImageFromFileSystem(long fileName) throws IOException {
        Optional<MstTenant> fileData = tenantRepo.findById(fileName);
        String filePath=fileData.get().getAdharCardFolder();
        byte[] images = commonService.downloadImageFromFileSystem(filePath);

       return images;
    }

	@Override
	public String saveRent(RentInfo bo) {
		rentInfoRepo.save(bo);
		return null;
	}

}
