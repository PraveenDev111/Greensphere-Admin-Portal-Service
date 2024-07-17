package com.greensphere.admin_portal_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.greensphere.admin_portal_service.model.usersModel;
import com.greensphere.admin_portal_service.repository.userRepository;

public interface userService {
    usersModel insert(usersModel user);

    usersModel update(usersModel user);

    boolean delete(long id);

    usersModel fetchById(long id);

    usersModel fetchByEmail(String email);

    usersModel updateStatus(usersModel user, int status);

    List<usersModel> fetchAllUsers();
}
