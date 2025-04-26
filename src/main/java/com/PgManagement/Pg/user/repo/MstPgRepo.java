package com.PgManagement.Pg.user.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.PgManagement.Pg.user.entity.MstPg;
import com.PgManagement.Pg.user.entity.VwRoomLayout;
@Repository
public interface MstPgRepo extends JpaRepository<MstPg, Long>{
	
	@Query(value="SELECT pg_id, pg_name FROM pg_management.mst_pg where user_id=?1",nativeQuery=true)
	List<Map<String,Object>> getPgDtlsByUserId(long user_id);

	@Query(value = "select case when\r\n"
			+ "count(*)>0 then 'Y' else 'N' end as flag \r\n"
			+ "from Mst_Pg where pg_id='3' ",nativeQuery = true)
	String getPgCodeByPgId(String pgCode);

	
}
