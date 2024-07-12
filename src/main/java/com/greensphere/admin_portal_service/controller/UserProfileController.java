package com.greensphere.admin_portal_service.controller;

import com.greensphere.admin_portal_service.model.UserProfileModel;
import com.greensphere.admin_portal_service.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/userprofiles")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/insert")
    public UserProfileModel insertUserProfile(@RequestBody UserProfileModel userProfile) {
        return userProfileService.insert(userProfile);
    }

    @PutMapping("/update")
    public UserProfileModel updateUserProfile(@RequestBody UserProfileModel userProfile) {
        return userProfileService.update(userProfile);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUserProfile(@PathVariable int id) {
        return userProfileService.delete(id);
    }

    @GetMapping("/{id}")
    public UserProfileModel fetchUserProfileById(@PathVariable int id) {
        return userProfileService.fetchById(id);
    }

    @GetMapping("/email/{email}")
    public UserProfileModel fetchUserProfileByEmail(@PathVariable String email) {
        return userProfileService.fetchByEmail(email);
    }
}
