package com.PgManagement.Pg.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Mst_Room")
public class MstRoom {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long room_id;
	 private String room_no;
	 private Long tenant_id;
	 private String no_of_beds;
//	 private Long floor_id;
	public Long getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Long room_id) {
		this.room_id = room_id;
	}
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	public Long getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(Long tenant_id) {
		this.tenant_id = tenant_id;
	}
	public String getNo_of_beds() {
		return no_of_beds;
	}
	public void setNo_of_beds(String no_of_beds) {
		this.no_of_beds = no_of_beds;
	}
//	public Long getFloor_id() {
//		return floor_id;
//	}
//	public void setFloor_id(Long floor_id) {
//		this.floor_id = floor_id;
//	}
	 
}
