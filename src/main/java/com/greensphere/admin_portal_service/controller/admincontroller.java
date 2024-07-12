package com.greensphere.admin_portal_service.controller;

import com.greensphere.admin_portal_service.model.usersModel;
import com.greensphere.admin_portal_service.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class admincontroller {

    @Autowired
    userService UserService;

    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping("/users")
    usersModel insertUser(@RequestBody usersModel user) {
        return UserService.insert(user);
    }

    @PutMapping("/users")
    public usersModel updateUser(@RequestBody usersModel user) {
        return UserService.update(user);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return UserService.delete(id);
    }

    @GetMapping("/users/{id}")
    public usersModel fetchUserById(@PathVariable int id) {
        return UserService.fetchById(id);
    }

    @GetMapping("/users/email/{email}")
    public usersModel fetchUserByEmail(@PathVariable String email) {
        return UserService.fetchByEmail(email);
    }
}
