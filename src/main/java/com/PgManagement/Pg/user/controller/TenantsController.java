package com.PgManagement.Pg.user.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.PgManagement.Pg.user.dto.VAlidationPgCode;
import com.PgManagement.Pg.user.entity.MstTenant;
import com.PgManagement.Pg.user.entity.RentInfo;
import com.PgManagement.Pg.user.entity.MstTenantRequest;
import com.PgManagement.Pg.user.service.TenantsService;
import org.springframework.http.MediaType;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/tenants")
public class TenantsController {
	@Autowired TenantsService tenantsService;
	
	@PostMapping("/isVAlidationPgCode")
	public ResponseEntity<?> isVAlidationPgCode(@ModelAttribute  VAlidationPgCode code){
		 Map<String, Object> result = tenantsService.isVAlidationPgCode(code);
		    
		    if ("Y".equals(result.get("isValid"))) {
		        return ResponseEntity.ok(result);  // Contains both isValid and pgDetails
		    } else {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);  // Only isValid=N
		    }
		
	}
	
	
	@PostMapping("/registerTenant")
	public ResponseEntity<?> uploadImageToFIleSystem(@ModelAttribute @RequestBody MstTenantRequest bo) throws IOException {
		String uploadImage = tenantsService.uploadImageToFileSystem(bo);
		return ResponseEntity.status(HttpStatus.OK).body(Map.of("reqId", uploadImage));
	
	}
	@GetMapping("/fileSystem/{fileName}")
	public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable long fileName) throws IOException {
	    byte[] imageData = tenantsService.downloadImageFromFileSystem(fileName);
	    return ResponseEntity.status(HttpStatus.OK)
	            .contentType(MediaType.valueOf("image/png"))
	            .body(imageData);
	}

	@PostMapping("/saveRent")
	public ResponseEntity<?> saveRent(@RequestBody @ModelAttribute RentInfo bo) throws IOException {
		bo.setCrtDate(new Date());
		RentInfo returnData = tenantsService.saveRent(bo);
		return ResponseEntity.ok(returnData);
	}
	
	@PutMapping("/termUpdation/{reqId}")
	public ResponseEntity<?> updateAgreementInfo(@PathVariable Long reqId, @ModelAttribute  MstTenantRequest agreementData) {
		String updateAgreementInfo = tenantsService.updateAgreementInfo(reqId,agreementData);
	    return ResponseEntity.ok(updateAgreementInfo);
	}
}
