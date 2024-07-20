package com.greensphere.admin_portal_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.greensphere.admin_portal_service.service.userService;
import com.greensphere.admin_portal_service.model.UserRoleModel;
import com.greensphere.admin_portal_service.model.UserRoleRequest;
import com.greensphere.admin_portal_service.model.usersModel;
import com.greensphere.admin_portal_service.repository.UserRoleRepository;
import com.greensphere.admin_portal_service.service.UserRoleService;

@RestController
@RequestMapping(value = "/api/v1/admin/userrole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private userService userService;

    @PutMapping("/add")
    public UserRoleModel addRoleToUser(@RequestBody UserRoleRequest userRoleRequest) {
        usersModel user = userService.fetchById(userRoleRequest.getUserId());
        return userRoleService.addRoleToUser(user, userRoleRequest.getRole());
    }

    @GetMapping("/roles/{userId}")
    public List<UserRoleModel> getRolesByUserId(@PathVariable Long userId) {
        return userRoleService.getRolesByUserId(userId);
    }

}
