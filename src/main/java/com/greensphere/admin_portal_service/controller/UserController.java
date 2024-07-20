package com.greensphere.admin_portal_service.controller;

import com.greensphere.admin_portal_service.model.usersModel;
import com.greensphere.admin_portal_service.service.userService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/status/{status}")
    public usersModel updateStatus(@RequestBody usersModel user, @PathVariable int status) {
        return UserService.updateStatus(user, status);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return UserService.delete(id);
    }

    @GetMapping("/get/{id}")
    public usersModel fetchUserById(@PathVariable int id) {
        return UserService.fetchById(id);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<usersModel>> fetchAll() {
        List<usersModel> allUsers = UserService.fetchAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public usersModel fetchUserByEmail(@PathVariable String email) {
        return UserService.fetchByEmail(email);
    }

    @GetMapping("/check")
    public String getMethodName() {
        return "Hello";
    }

}
