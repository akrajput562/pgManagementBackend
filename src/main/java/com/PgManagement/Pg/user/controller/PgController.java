package com.PgManagement.Pg.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PgManagement.Pg.user.entity.MstOtp;
import com.PgManagement.Pg.user.entity.MstPg;
import com.PgManagement.Pg.user.entity.MstUser;
import com.PgManagement.Pg.user.entity.VwRoomLayout;
import com.PgManagement.Pg.user.service.MyUserDetailsService;
import com.PgManagement.Pg.user.service.PgService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/pg")
public class PgController {
	@Autowired PgService pgservice;
	@Autowired MyUserDetailsService myUserDetailsService;
	
	    @PreAuthorize("hasAuthority('1')")
	    @PostMapping("/savePgData")
	    public ResponseEntity<?> createPG( @RequestBody MstPg pgdat,HttpServletRequest request){
	    MstPg savedPg = pgservice.createPG(pgdat);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedPg);
	    }

	    public ResponseEntity<String> sendMail(String email){
	    	pgservice.sendEmail(email);
	        return ResponseEntity.ok("Email Sent Successfully");
	    }
	    

	    @PostMapping("/verifyOtp")
	    public ResponseEntity<?> verifyOTP(@ModelAttribute  MstUser user ,String otp) {
	        boolean isVerified = pgservice.verifyOTP(user.getEmail(),otp );

	        if (isVerified) {
	        	return ResponseEntity.ok().body(myUserDetailsService.createUser(user));
	        } else {
	        	 return ResponseEntity.ok("Otp Verification Failed");
	        }
	    }
	    
	    @PreAuthorize("hasAuthority('1')")
	    @GetMapping("/getRoomLayoutDtls")
	    public ResponseEntity<?> getRoomLayoutDtls(@RequestBody VwRoomLayout vwRoomLayout){
	    	 List<VwRoomLayout> layouts = pgservice.getRoomLayoutsByPgAndUser(
	    			 vwRoomLayout.getPg_id(), vwRoomLayout.getUser_id()
	         );

	         if (layouts.isEmpty()) {
	             return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                                  .body("No room layout found for this PG and user.");
	         }

	         return ResponseEntity.ok(layouts);
	    	
	    }
	  
}
