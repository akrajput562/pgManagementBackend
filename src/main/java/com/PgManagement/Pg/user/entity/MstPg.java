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
@Table(name = "Mst_Pg")
public class MstPg {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long pg_id;
	 private String pg_name;
	 private Long user_id;
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name="fk_pg_id",referencedColumnName = "pg_id")
	 private List<MstFloor> floor_id;
	 
	public Long getPg_id() {
		return pg_id;
	}
	public void setPg_id(Long pg_id) {
		this.pg_id = pg_id;
	}
	public String getPg_name() {
		return pg_name;
	}
	public void setPg_name(String pg_name) {
		this.pg_name = pg_name;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public List<MstFloor> getFloor_id() {
		return floor_id;
	}
	public void setFloor_id(List<MstFloor> floor_id) {
		this.floor_id = floor_id;
	}
	
}
