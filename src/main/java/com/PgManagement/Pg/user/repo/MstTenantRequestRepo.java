package com.PgManagement.Pg.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PgManagement.Pg.user.entity.MstTenantRequest;

public interface MstTenantRequestRepo extends JpaRepository<MstTenantRequest, Long>{

	@Query(value="SELECT \r\n"
			+ "    CASE \r\n"
			+ "        WHEN EXISTS (\r\n"
			+ "            SELECT 1\r\n"
			+ "            FROM pg_management.mst_tenant AS req\r\n"
			+ "            LEFT JOIN pg_management.mst_pg AS pg \r\n"
			+ "                ON req.property_id = pg.pg_id\r\n"
			+ "            WHERE req.email = ?2\r\n"
			+ "              AND pg.pg_ok_code =?1\r\n"
			+ "        )\r\n"
			+ "        THEN 'Y'\r\n"
			+ "        ELSE 'N'\r\n"
			+ "    END AS result",nativeQuery = true)
	String checkExistingUserOrNot(String pgCode, String email);

}
