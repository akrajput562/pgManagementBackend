package com.PgManagement.Pg.user.entity;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	 private String who_can_stay;

	 private String available_for;
	 private String pgOkCode;
	 @OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "fk_pg_id", referencedColumnName = "pg_id")  
		private List<MstFloor> floors;
	 
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
	 
	public void setWhoCanStay(List<String> who_can_stay) {
        this.who_can_stay = String.join(",", who_can_stay);
    }

    // ✅ Convert String to List when retrieving
    public List<String> getWhoCanStay() {
        return who_can_stay != null ? Arrays.asList(who_can_stay.split(",")) : new ArrayList<>();
    }

    public void setAvailableFor(List<String> available_for) {
        this.available_for = String.join(",", available_for);
    }

    public List<String> getAvailableFor() {
        return available_for != null ? Arrays.asList(available_for.split(",")) : new ArrayList<>();
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
	public String getWho_can_stay() {
		return who_can_stay;
	}
	public void setWho_can_stay(String who_can_stay) {
		this.who_can_stay = who_can_stay;
	}
	public String getAvailable_for() {
		return available_for;
	}
	public void setAvailable_for(String available_for) {
		this.available_for = available_for;
	}
	public List<MstFloor> getFloors() {
		return floors;
	}
	public void setFloors(List<MstFloor> floors) {
		this.floors = floors;
	}
	public String getPgOkCode() {
		return pgOkCode;
	}
	public void setPgOkCode(String pgOkCode) {
		this.pgOkCode = pgOkCode;
	}

	
}
