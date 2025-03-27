package com.PgManagement.Pg.user.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Mst_floor")
public class MstFloor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long floor_id;
	private String floor_no;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_floor_id",referencedColumnName = "floor_id")
	private List<MstRoom> room;
	
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
	public List<MstRoom> getRoom() {
		return room;
	}
	public void setRoom(List<MstRoom> room) {
		this.room = room;
	}
	
	
	
	
}
