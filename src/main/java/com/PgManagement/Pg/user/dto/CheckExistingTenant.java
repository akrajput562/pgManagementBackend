package com.PgManagement.Pg.user.dto;

public class CheckExistingTenant {
	private String email;
    private String pgOkCode;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPgOkCode() {
		return pgOkCode;
	}
	public void setPgOkCode(String pgOkCode) {
		this.pgOkCode = pgOkCode;
	}
    
}
