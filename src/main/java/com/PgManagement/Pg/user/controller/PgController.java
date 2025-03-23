package com.PgManagement.Pg.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PgManagement.Pg.user.entity.MstPg;
import com.PgManagement.Pg.user.service.PgService;

@RestController
@RequestMapping("/pg")
public class PgController {
	@Autowired PgService pgservice;
	
	    @PreAuthorize("hasAuthority('owner')")
	    @PostMapping("/savePgData")
	    public ResponseEntity<?> createPG(@ModelAttribute @RequestBody MstPg pgdat){
			
	            return ResponseEntity.status(HttpStatus.CREATED).body(pgservice.createPG(pgdat));

	    }

}
