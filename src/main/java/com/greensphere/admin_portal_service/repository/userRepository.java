package com.greensphere.admin_portal_service.repository;

import com.greensphere.admin_portal_service.model.usersModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Repository
@EnableJpaRepositories
public interface userRepository extends JpaRepository<usersModel,Integer >{

}
