package com.greensphere.admin_portal_service.controller;

import com.greensphere.admin_portal_service.model.usersModel;
import com.greensphere.admin_portal_service.service.SystemLogService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin/users")
public class UserController {

    @Autowired
    userService UserService;

    @Autowired
    SystemLogService systemLogservice;

    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping("/insert")
    usersModel insertUser(@RequestBody usersModel user) {
        usersModel createdUser = UserService.insert(user);
        // for long 10, replace with authentication logic
        systemLogservice.logAction((long) 10, "CREATE USER", "Created User with id: " + createdUser.getId());
        return createdUser;
    }

    @PutMapping("/update")
    public usersModel updateUser(@RequestBody usersModel user) {
        systemLogservice.logAction((long) 10, "EDIT USER", "Edited User with id: " + user.getId());
        return UserService.update(user);
    }

    @PutMapping("/status/{status}")
    public usersModel updateStatus(@RequestBody usersModel user, @PathVariable int status) {
        systemLogservice.logAction((long) 10, "CHECKED STATUS", "Checked status of User: " + user.getId());
        return UserService.updateStatus(user, status);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable int id) {
        boolean isDeleted = UserService.delete(id);
        if (isDeleted) {
            systemLogservice.logAction((long) 12, "DELETED USER", "Deleted User with ID: " + id);
            return ResponseEntity.ok("User deleted successfully.") != null;
        } else {
            systemLogservice.logAction((long) 12, "ATTEMPTED TO DELETE USER",
                    "Attempted to delete User with ID: " + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user.") != null;
        }
    }

    @GetMapping("/get/{id}")
    public usersModel fetchUserById(@PathVariable int id) {
        return UserService.fetchById(id);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<usersModel>> fetchAll(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "25") int limit) {
        List<usersModel> allusers = UserService.fetchAllUsers(offset, limit);
        return new ResponseEntity<>(allusers, HttpStatus.OK);
    }

    @GetMapping(value = "/allusers", produces = "application/json")
    public ResponseEntity<List<usersModel>> fetchAll() {
        List<usersModel> allUsers = UserService.fetchAllUsers(0, 1000);
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
