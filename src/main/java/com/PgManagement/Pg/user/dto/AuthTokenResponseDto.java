package com.PgManagement.Pg.user.dto;

public class AuthTokenResponseDto {
	 private String authToken;

	    public AuthTokenResponseDto(String authToken) {
	        this.authToken = authToken;
	    }

	    public String getAuthToken() {
	        return authToken;
	    }

	    public void setAuthToken(String authToken) {
	        this.authToken = authToken;
	    }
}
