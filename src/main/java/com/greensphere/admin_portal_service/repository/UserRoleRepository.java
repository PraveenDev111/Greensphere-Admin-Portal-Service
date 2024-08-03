package com.greensphere.admin_portal_service.repository;

import com.greensphere.admin_portal_service.model.UserRoleModel;
import com.greensphere.admin_portal_service.model.usersModel;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

@Repository
@EnableJpaRepositories
public interface UserRoleRepository extends JpaRepository<UserRoleModel, Long> {
    Optional<UserRoleModel> findByUser(usersModel user);

    List<UserRoleModel> findByUserId(Long userId);

    @Modifying
    @Query("DELETE FROM UserRole ur WHERE ur.userId = :userId")
    void deleteByUserId(@Param("userId") long userId);

}
