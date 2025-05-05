package com.PgManagement.Pg.user.repo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.PgManagement.Pg.user.entity.MstPg;
import com.PgManagement.Pg.user.entity.MstUser;
import com.PgManagement.Pg.user.entity.VwRoomLayout;
@Repository
public interface MstPgRepo extends JpaRepository<MstPg, Long>{
	
	@Query(value="SELECT pg_id, pg_name FROM pg_management.mst_pg where user_id=?1",nativeQuery=true)
	List<Map<String,Object>> getPgDtlsByUserId(long user_id);

	@Query(value = "select case when\r\n"
			+ "count(*)>0 then 'Y' else 'N' end as flag \r\n"
			+ "from Mst_Pg where pgOkCode= ?1 ",nativeQuery = true)
	String getPgCodeByPgId(String pgCode);

	@Query(value="select * from Mst_Pg where pgOkCode=?1",nativeQuery =true)
	MstPg getPgDetailsByCode(String pgCode);

	@Query("""
		    FROM MstPg p
			JOIN p.floors f
			JOIN f.room r
			WHERE p.pg_id = :pgId
		""")
		Optional<MstPg> findPgWithFloorsAndRoomsById(Long pgId);
}
