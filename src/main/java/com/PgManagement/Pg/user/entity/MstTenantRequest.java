package com.PgManagement.Pg.user.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Tenant_Request")
public class MstTenantRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reqId;
	private String tenantName;
	private Date dateOfBirth;
	private String mobileNumber;
	private String fatherName;
	private String fatherMobileNumber;
	
	@Transient private MultipartFile adharCard;
	@Transient private MultipartFile companyId;
	private String adharCardFolder;
	private String companyIdFolder;
	private String property_id;
	private String status;
	private String approval_status="P";
	private String email;
	private Double monthlyRent;
	private Double securityDeposit;
	private Double maintenance;
	private String agreementStartDate;
	private String rentCycle;
	private String cycleStartDate;
	private Boolean agreedToTerms;
	public Long getReqId() {
		return reqId;
	}
	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getFatherMobileNumber() {
		return fatherMobileNumber;
	}
	public void setFatherMobileNumber(String fatherMobileNumber) {
		this.fatherMobileNumber = fatherMobileNumber;
	}
	public MultipartFile getAdharCard() {
		return adharCard;
	}
	public void setAdharCard(MultipartFile adharCard) {
		this.adharCard = adharCard;
	}
	public MultipartFile getCompanyId() {
		return companyId;
	}
	public void setCompanyId(MultipartFile companyId) {
		this.companyId = companyId;
	}
	public String getAdharCardFolder() {
		return adharCardFolder;
	}
	public void setAdharCardFolder(String adharCardFolder) {
		this.adharCardFolder = adharCardFolder;
	}
	public String getCompanyIdFolder() {
		return companyIdFolder;
	}
	public void setCompanyIdFolder(String companyIdFolder) {
		this.companyIdFolder = companyIdFolder;
	}
	public String getProperty_id() {
		return property_id;
	}
	public void setProperty_id(String property_id) {
		this.property_id = property_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApproval_status() {
		return approval_status;
	}
	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getMonthlyRent() {
		return monthlyRent;
	}
	public void setMonthlyRent(Double monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	public Double getSecurityDeposit() {
		return securityDeposit;
	}
	public void setSecurityDeposit(Double securityDeposit) {
		this.securityDeposit = securityDeposit;
	}
	public Double getMaintenance() {
		return maintenance;
	}
	public void setMaintenance(Double maintenance) {
		this.maintenance = maintenance;
	}
	public String getAgreementStartDate() {
		return agreementStartDate;
	}
	public void setAgreementStartDate(String agreementStartDate) {
		this.agreementStartDate = agreementStartDate;
	}
	public String getRentCycle() {
		return rentCycle;
	}
	public void setRentCycle(String rentCycle) {
		this.rentCycle = rentCycle;
	}
	public String getCycleStartDate() {
		return cycleStartDate;
	}
	public void setCycleStartDate(String cycleStartDate) {
		this.cycleStartDate = cycleStartDate;
	}
	public Boolean getAgreedToTerms() {
		return agreedToTerms;
	}
	public void setAgreedToTerms(Boolean agreedToTerms) {
		this.agreedToTerms = agreedToTerms;
	}

}
