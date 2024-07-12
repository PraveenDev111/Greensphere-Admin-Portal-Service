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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin/users")
public class UserController {

    @Autowired
    userService UserService;

    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping("/insert")
    usersModel insertUser(@RequestBody usersModel user) {
        return UserService.insert(user);
    }

    @PutMapping("/update")
    public usersModel updateUser(@RequestBody usersModel user) {
        return UserService.update(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return UserService.delete(id);
    }

    @GetMapping("/{id}")
    public usersModel fetchUserById(@PathVariable int id) {
        return UserService.fetchById(id);
    }

    @GetMapping("/{email}")
    public usersModel fetchUserByEmail(@PathVariable String email) {
        return UserService.fetchByEmail(email);
    }
}
