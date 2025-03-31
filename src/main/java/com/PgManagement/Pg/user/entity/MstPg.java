package com.PgManagement.Pg.user.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
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
	 private String pg_address;
	 private String pin_code;
	 private String city;
	 private String state;
	 private String property_type;
	
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name="fk_pg_id",referencedColumnName = "pg_id")
	 private List<MstFloor> floor_id;
	 @ElementCollection
	 private List<String> whoCanStay;

	 @ElementCollection
	 private List<String> availableFor;
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
	public String getPg_address() {
		return pg_address;
	}
	public void setPg_address(String pg_address) {
		this.pg_address = pg_address;
	}
	public String getPin_code() {
		return pin_code;
	}
	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProperty_type() {
		return property_type;
	}
	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}
	
}
