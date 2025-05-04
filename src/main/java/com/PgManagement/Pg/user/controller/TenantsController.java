package com.PgManagement.Pg.user.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.PgManagement.Pg.user.dto.VAlidationPgCode;
import com.PgManagement.Pg.user.entity.MstTenant;
import com.PgManagement.Pg.user.entity.RentInfo;
import com.PgManagement.Pg.user.service.TenantsService;
import org.springframework.http.MediaType;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/tenants")
public class TenantsController {
	@Autowired TenantsService tenantsService;
	
	@PostMapping("/isVAlidationPgCode")
	public ResponseEntity<?> isVAlidationPgCode(@ModelAttribute VAlidationPgCode code){
		Boolean flag=tenantsService.isVAlidationPgCode(code);
		HttpStatus status = flag ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
		return ResponseEntity.status(status).body(flag);
		
	}
	
	
	@PostMapping("/registerTenant")
	public ResponseEntity<?> uploadImageToFIleSystem(@RequestBody MstTenant bo) throws IOException {
		String uploadImage = tenantsService.uploadImageToFileSystem(bo);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}
	@GetMapping("/fileSystem/{fileName}")
	public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable long fileName) throws IOException {
	    byte[] imageData = tenantsService.downloadImageFromFileSystem(fileName);
	    return ResponseEntity.status(HttpStatus.OK)
	            .contentType(MediaType.valueOf("image/png"))
	            .body(imageData);
	}

	@PostMapping("/saveRent")
	public ResponseEntity<?> saveRent(@RequestBody RentInfo bo) throws IOException {
		String uploadImage = tenantsService.saveRent(bo);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}
}
