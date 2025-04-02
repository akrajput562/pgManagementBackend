package com.PgManagement.Pg.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PgManagement.Pg.security.JwtUtil;
import com.PgManagement.Pg.security.UserPrincipal;
import com.PgManagement.Pg.user.dto.AuthTokenResponseDto;
import com.PgManagement.Pg.user.dto.UserDto;
import com.PgManagement.Pg.user.entity.MstUser;
import com.PgManagement.Pg.user.service.MyUserDetailsService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	 @Autowired
	    private JwtUtil jwtUtil;
	    @Autowired
	    private AuthenticationManager authenticationManager;
	    @Autowired
	    private MyUserDetailsService userDetailsService;
	    
	    @Autowired PgController pgController;

	    @PostMapping("/register")
	    public void register(@ModelAttribute  MstUser user){
	    	pgController.sendMail(user.getEmail());
	     //  return userDetailsService.createUser(user);
	    }

	    @PostMapping("/login")
	    public ResponseEntity<AuthTokenResponseDto> login(@ModelAttribute @RequestBody UserDto user){
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	        
	        
	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        List<String> roles = authentication.getAuthorities().stream()
	                .map(GrantedAuthority::getAuthority)
	                .toList();

	        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
	        long userId=0;
	        if (userDetails instanceof UserPrincipal) {
	        	UserPrincipal customUser = (UserPrincipal) userDetails;
	            System.out.println("User ID: " + customUser.getUser_id());
	            userId=customUser.getUser_id();
	        }
	        String token = jwtUtil.generateToken(userDetails.getUsername(),roles, userId);
	        return ResponseEntity.ok(new AuthTokenResponseDto(token));

	    }

	}