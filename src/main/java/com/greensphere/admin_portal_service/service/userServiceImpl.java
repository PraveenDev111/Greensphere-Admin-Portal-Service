package com.greensphere.admin_portal_service.service;

import com.greensphere.admin_portal_service.model.usersModel;
import com.greensphere.admin_portal_service.repository.userRepository;
import java.util.Optional;

public class userServiceImpl implements userService {

    userRepository userRepo;
    @Override
    public usersModel insert(usersModel user) {
        return userRepo.save(user);
    }

    @Override
    public usersModel update(usersModel user) {
        Optional<usersModel> existingUser = userRepo.findById(user.getId());
        if (existingUser.isPresent()) {
            usersModel updatedUser = existingUser.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setCreatedAt(user.getCreatedAt());
            return userRepo.save(updatedUser);
        } else {
            throw new RuntimeException("User not found with id: " + user.getId());
        }
    }

    @Override
    public boolean delete(int id) {
        Optional<usersModel> existingUser = userRepo.findById(id);
        if (existingUser.isPresent()) {
            userRepo.delete(existingUser.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public usersModel fetchById(int id) {
        Optional<usersModel> user = userRepo.findById(id);
        return user.orElse(null);
    }

    @Override
    public usersModel fetchByEmail(String email) {
        return null;
    }
}
