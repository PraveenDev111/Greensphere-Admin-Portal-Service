package com.greensphere.admin_portal_service.service;

import com.greensphere.admin_portal_service.model.usersModel;

public interface userService {
    usersModel insert(usersModel user);
    usersModel update(usersModel user);
    boolean delete(int id);
    usersModel fetchById(int id);
    usersModel fetchByEmail(String email);
}
