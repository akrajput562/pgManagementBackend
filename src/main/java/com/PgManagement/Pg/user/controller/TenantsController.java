package com.PgManagement.Pg.user.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.PgManagement.Pg.user.dto.VAlidationPgCode;
import com.PgManagement.Pg.user.entity.MstTenant;
import com.PgManagement.Pg.user.entity.MstTenantRequest;
import com.PgManagement.Pg.user.service.TenantsService;

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
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}




}
