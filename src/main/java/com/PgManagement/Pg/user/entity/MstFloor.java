package com.PgManagement.Pg.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Mst_floor")
public class MstFloor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long floor_id;
	private String floor_no;
	private String room_id;
	public Long getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(Long floor_id) {
		this.floor_id = floor_id;
	}
	public String getFloor_no() {
		return floor_no;
	}
	public void setFloor_no(String floor_no) {
		this.floor_no = floor_no;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	
	
}
