package com.greensphere.admin_portal_service.service;

import java.util.List;
import com.greensphere.admin_portal_service.model.usersModel;

public interface userService {
    usersModel insert(usersModel user);

    usersModel update(usersModel user);

    boolean delete(long id);

    usersModel fetchById(long id);

    usersModel fetchByEmail(String email);

    usersModel updateStatus(usersModel user, int status);

    usersModel updateRole(usersModel user, String role);

    List<usersModel> fetchAllUsers(int offset, int limit);

    usersModel fetchByUsername(String username);
}
