package com.PgManagement.Pg.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PgManagement.Pg.user.entity.MstOtp;

public interface MstOtpRepo extends JpaRepository<MstOtp, Long>{

	@Query(value="select otp from pg_management.mst_otp where email= ?1 order by crt_date desc limit 1",nativeQuery=true)
	String getOtpByEmail(String email);



}
