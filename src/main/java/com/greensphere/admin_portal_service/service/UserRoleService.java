package com.greensphere.admin_portal_service.service;

import java.util.List;

import com.greensphere.admin_portal_service.model.UserRoleModel;
import com.greensphere.admin_portal_service.model.usersModel;

public interface UserRoleService {
    public UserRoleModel addRoleToUser(usersModel user, String role);

    public List<UserRoleModel> getRolesByUserId(Long userId);
}