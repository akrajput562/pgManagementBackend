package com.PgManagement.Pg.user.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PgManagement.Pg.user.entity.RentInfo;

public interface RentInfoRepo extends JpaRepository<RentInfo, Long>{

	@Query(value = "SELECT * FROM pg_management.rent_info where pg_code=?1",nativeQuery = true)
	List<Map<String, Object>> getRentNotification(String pgCode);


}
