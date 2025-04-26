package com.PgManagement.Pg.user.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PgManagement.Pg.user.dto.VAlidationPgCode;
import com.PgManagement.Pg.user.service.TenantsService;

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

}
