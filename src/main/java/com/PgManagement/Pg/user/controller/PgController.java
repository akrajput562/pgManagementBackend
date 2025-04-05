package com.PgManagement.Pg.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PgManagement.Pg.user.entity.MstPg;
import com.PgManagement.Pg.user.entity.MstUser;
import com.PgManagement.Pg.user.service.MyUserDetailsService;
import com.PgManagement.Pg.user.service.PgService;

@RestController
@RequestMapping("/pg")
public class PgController {
	@Autowired PgService pgservice;
	@Autowired MyUserDetailsService myUserDetailsService;
	
	    @PreAuthorize("hasAuthority('owner')")
	    @PostMapping("/savePgData")
	    public ResponseEntity<?> createPG( @RequestBody MstPg pgdat){
	    MstPg savedPg = pgservice.createPG(pgdat);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedPg);
	    }

	    public ResponseEntity<String> sendMail(String email){
	    	pgservice.sendEmail(email);
	        return ResponseEntity.ok("Email Sent Successfully");
	    }
	    

	    @PostMapping("/verifyOtp")
	    public ResponseEntity<?> verifyOTP(@RequestBody  MstUser user ,@RequestParam String otp) {
	        boolean isVerified = pgservice.verifyOTP(user.getEmail(),otp );

	        if (isVerified) {
	        	return ResponseEntity.ok().body(myUserDetailsService.createUser(user));
	        } else {
	        	 return ResponseEntity.ok("Otp Verification Failed");
	        }
	    }

}
