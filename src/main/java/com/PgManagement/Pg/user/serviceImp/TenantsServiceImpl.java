package com.PgManagement.Pg.user.serviceImp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.PgManagement.Pg.user.dto.CheckExistingTenant;
import com.PgManagement.Pg.user.dto.VAlidationPgCode;
import com.PgManagement.Pg.user.entity.MstPg;
import com.PgManagement.Pg.user.entity.MstTenant;

import com.PgManagement.Pg.user.entity.RentInfo;
import com.PgManagement.Pg.user.repo.MstPgRepo;
import com.PgManagement.Pg.user.repo.RentInfoRepo;
import com.PgManagement.Pg.user.entity.MstTenantRequest;
import com.PgManagement.Pg.user.repo.MstPgRepo;
import com.PgManagement.Pg.user.repo.MstTenantRequestRepo;
import com.PgManagement.Pg.user.repo.TenantRepo;
import com.PgManagement.Pg.user.service.TenantsService;
import com.PgManagement.Pg.util.CommonService;

@Component
public class TenantsServiceImpl implements TenantsService{
@Autowired MstPgRepo mstPgRepo;
@Autowired TenantRepo tenantRepo;
@Autowired CommonService commonService;
@Autowired RentInfoRepo rentInfoRepo;

@Autowired MstTenantRequestRepo mstTenantReqRepo;
	
	@Override
	public  Map<String, Object> isVAlidationPgCode(VAlidationPgCode code) {
		 Map<String, Object> response = new HashMap<>();
		 String flag=mstPgRepo.getPgCodeByPgId(code.getPgCode());
		  response.put("isValid", flag);
		  if ("Y".equalsIgnoreCase(flag)) {
		        MstPg details = mstPgRepo.getPgDetailsByCode(code.getPgCode());
		        response.put("pgDetails", details);  // Directly return entity
		    }
		  return response;
	}
	
	@Override
	 public String uploadImageToFileSystem(MstTenantRequest bo) throws IOException {
		String adharFolder="";
		String companyFolder="";
		if(bo.getAdharCard().getOriginalFilename()!=null || bo.getCompanyId().getOriginalFilename()!=null) {
			
			 adharFolder = commonService.uploadImage(bo.getAdharCard());
        	 companyFolder = commonService.uploadImage(bo.getCompanyId());
			
		}
			bo.setAdharCardFolder(adharFolder);
	        bo.setCompanyIdFolder(companyFolder);
	        MstTenantRequest save = mstTenantReqRepo.save(bo);
	        return save.getReqId().toString();
	    }
	
	@Override
	public byte[] downloadImageFromFileSystem(long fileName) throws IOException {
        Optional<MstTenant> fileData = tenantRepo.findById(fileName);
        String filePath=fileData.get().getAdharCardFolder();
        byte[] images = commonService.downloadImageFromFileSystem(filePath);

       return images;
    }

	@Override
	public RentInfo saveRent(RentInfo bo) {
		return rentInfoRepo.save(bo);
	}

	@Override
	public String updateAgreementInfo(Long reqId, MstTenantRequest agreementData) {
		MstTenantRequest existing = mstTenantReqRepo.findById(reqId)
		        .orElseThrow(() -> new RuntimeException("Request not found"));

		    existing.setMonthlyRent(agreementData.getMonthlyRent());
		    existing.setSecurityDeposit(agreementData.getSecurityDeposit());
		    existing.setMaintenance(agreementData.getMaintenance());
		    existing.setAgreementStartDate(agreementData.getAgreementStartDate());
		    existing.setRentCycle(agreementData.getRentCycle());
		    existing.setCycleStartDate(agreementData.getCycleStartDate());
		    existing.setAgreedToTerms(agreementData.getAgreedToTerms());

		    mstTenantReqRepo.save(existing);
		    return "Agreement info updated successfully";
	
	}
	
	@Override
		public String checkExistingUser(CheckExistingTenant tenantDto) {
		String checkExistingUserOrNot="N";
		if(tenantDto.getEmail()!=null && !tenantDto.getEmail().equals("")
				&& tenantDto.getPgOkCode()!=null && !tenantDto.getPgOkCode().equals("")) {
			 checkExistingUserOrNot = mstTenantReqRepo.checkExistingUserOrNot(tenantDto.getPgOkCode(),tenantDto.getEmail());
		}
			return checkExistingUserOrNot;
		}

}
