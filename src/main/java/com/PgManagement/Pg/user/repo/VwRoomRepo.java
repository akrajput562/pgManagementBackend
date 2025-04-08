package com.PgManagement.Pg.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PgManagement.Pg.user.entity.VwRoomLayout;

public interface VwRoomRepo extends JpaRepository<VwRoomLayout, Long>{

  //  @Query(value = "SELECT * FROM pg_management.roomview WHERE pg_id = :pgId AND user_id = :userId", nativeQuery = true)
	@Query("SELECT r FROM VwRoomLayout r WHERE r.pg_id = :pg_id AND r.user_id = :user_id")
	List<VwRoomLayout> findByPgIdAndUserId(String pg_id, String user_id);

}
