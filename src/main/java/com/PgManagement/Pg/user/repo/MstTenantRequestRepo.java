package com.PgManagement.Pg.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PgManagement.Pg.user.entity.MstTenantRequest;

public interface MstTenantRequestRepo extends JpaRepository<MstTenantRequest, Long>{

}
