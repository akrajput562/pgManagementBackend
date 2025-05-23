package com.PgManagement.Pg.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PgManagement.Pg.user.entity.MstUser;

public interface MstUserRepo extends JpaRepository<MstUser, Long>{
	
	
	 Optional<MstUser> findByUsername(String name);
//	@Query(value = "",nativeQuery = true)
//	 Optional<MstUser> getLogInData(String name);

}
