package com.greensphere.admin_portal_service.controller;

import com.greensphere.admin_portal_service.model.usersModel;
import com.greensphere.admin_portal_service.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class admincontroller {

    @Autowired
    userService UserService;

    @RequestMapping(method = RequestMethod.POST)
    usersModel insertUser(@RequestBody usersModel user) {
        return UserService.insert(user);
    }

}
