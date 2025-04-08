package com.PgManagement.Pg.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roomview")
public class VwRoomLayout {

	@Id
	private long index;
	private String no_of_beds;
	private String room_no;
	private String pg_id;
	private String user_id;
	private String occupy;
	private String available_beds;
	

	public String getNo_of_beds() {
		return no_of_beds;
	}
	public void setNo_of_beds(String no_of_beds) {
		this.no_of_beds = no_of_beds;
	}
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	public String getPg_id() {
		return pg_id;
	}
	public void setPg_id(String pg_id) {
		this.pg_id = pg_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOccupy() {
		return occupy;
	}
	public void setOccupy(String occupy) {
		this.occupy = occupy;
	}
	public String getAvailable_beds() {
		return available_beds;
	}
	public void setAvailable_beds(String available_beds) {
		this.available_beds = available_beds;
	}
	
	
	
}
