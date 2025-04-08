package com.PgManagement.Pg.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PgManagement.Pg.user.entity.VwRoomLayout;

public interface VwRoomRepo extends JpaRepository<VwRoomLayout, String>{

    @Query(value = "SELECT * FROM pg_management.roomview WHERE pg_id = :pgId AND user_id = :userId", nativeQuery = true)
	List<VwRoomLayout> findByPgIdAndUserId(String pg_id, String user_id);

}
