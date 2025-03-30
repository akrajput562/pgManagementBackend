package com.PgManagement.Pg.user.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Mst_otp")
public class MstOtp {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long otp_id;
	 	
	 	private String email;
	 	private String otp;
	 	private Date crt_date;
		public MstOtp(String email, String otp,Date crt_date) {
			super();
			this.email = email;
			this.otp = otp;
			this.crt_date=crt_date;
		}
		
		

		public long getOtp_id() {
			return otp_id;
		}



		public void setOtp_id(long otp_id) {
			this.otp_id = otp_id;
		}



		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getOtp() {
			return otp;
		}
		public void setOtp(String otp) {
			this.otp = otp;
		}
	 	
	 	
}
