package com.PgManagement.Pg.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tenant_Request")
public class TenantsReq {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reqId;
	private String tenantsName;
	public Long getReqId() {
		return reqId;
	}
	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}
	public String getTenantsName() {
		return tenantsName;
	}
	public void setTenantsName(String tenantsName) {
		this.tenantsName = tenantsName;
	}
	
}
