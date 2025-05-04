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
@Table(name = "Mst_tenant")
public class MstTenant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tenant_id;
	private String name;
	private Date dob;
	private String Mob;
	private String fatherName;
	private String fatherMob;
	private long roleId = 2L;
	@Transient private MultipartFile adharCard;
	@Transient private MultipartFile companyId;
	private String adharCardFolder;
	private String companyIdFolder;
	private String email;
//	private String room_id;
//	private String owner_id;
	private String property_id;
	private String status;
	public Long getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(Long tenant_id) {
		this.tenant_id = tenant_id;
	}
//	public String getRoom_id() {
//		return room_id;
//	}
//	public void setRoom_id(String room_id) {
//		this.room_id = room_id;
//	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public String getOwner_id() {
//		return owner_id;
//	}
//	public void setOwner_id(String owner_id) {
//		this.owner_id = owner_id;
//	}
	public String getProperty_id() {
		return property_id;
	}
	public void setProperty_id(String property_id) {
		this.property_id = property_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMob() {
		return Mob;
	}
	public void setMob(String mob) {
		Mob = mob;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getFatherMob() {
		return fatherMob;
	}
	public void setFatherMob(String fatherMob) {
		this.fatherMob = fatherMob;
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
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
