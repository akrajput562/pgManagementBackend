package com.PgManagement.Pg.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PgManagement.Pg.user.entity.PgData;
@Repository
public interface PgDataRepo extends JpaRepository<PgData, Long>{

	
}
