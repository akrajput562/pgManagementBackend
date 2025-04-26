package com.PgManagement.Pg.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.PgManagement.Pg.user.entity.MstPg;
@Repository
public interface MstPgRepo extends JpaRepository<MstPg, Long>{

	@Query(value = "select case when\r\n"
			+ "count(*)>0 then 'Y' else 'N' end as flag \r\n"
			+ "from Mst_Pg where pg_id='3' ",nativeQuery = true)
	String getPgCodeByPgId(String pgCode);

	
}
