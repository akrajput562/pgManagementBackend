package com.PgManagement.Pg.user.dto;



public class UserDto {
	private String username;
    private String password;
    private String authtoken;
    private String userId;
	public UserDto(String username, String password,String token,String userId ) {
		super();
		this.username = username;
		this.password = password;
		this.authtoken =token;
		this.userId=userId;
	}
	public UserDto() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthtoken() {
		return authtoken;
	}
	public void setAuthtoken(String authtoken) {
		this.authtoken = authtoken;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
    
}
