package com.greensphere.admin_portal_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greensphere.admin_portal_service.model.SystemLogModel;

public interface SystemLogRepository extends JpaRepository<SystemLogModel, Long> {

}
