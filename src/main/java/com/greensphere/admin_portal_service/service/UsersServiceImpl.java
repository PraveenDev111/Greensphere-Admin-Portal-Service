package com.greensphere.admin_portal_service.service;

import com.greensphere.admin_portal_service.model.usersModel;
import com.greensphere.admin_portal_service.repository.userRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements userService {

    @Autowired
    userRepository userRepo;

    @Override
    public usersModel insert(usersModel user) {
        if (userRepo.existsById(user.getId())) {
            throw new RuntimeException("User with ID " + user.getId() + " already exists.");
        }
        return userRepo.save(user);
    }

    @Override
    public usersModel update(usersModel user) {
        Optional<usersModel> existingUser = userRepo.findById(user.getId());
        if (existingUser.isPresent()) {
            usersModel updatedUser = existingUser.get();

            if (user.getUsername() != null && !user.getUsername().isEmpty()) {
                updatedUser.setUsername(user.getUsername());
            }
            if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                updatedUser.setPassword(user.getPassword());
            }
            if (user.getEmail() != null && !user.getEmail().isEmpty()) {
                updatedUser.setEmail(user.getEmail());
            }
            if (user.getFirst_name() != null && !user.getFirst_name().isEmpty()) {
                updatedUser.setFirst_name(user.getFirst_name());
            }
            if (user.getLast_name() != null && !user.getLast_name().isEmpty()) {
                updatedUser.setLast_name(user.getLast_name());
            }
            if (user.getAddress() != null && !user.getAddress().isEmpty()) {
                updatedUser.setAddress(user.getAddress());
            }
            if (user.getContact_info() != null && !user.getContact_info().isEmpty()) {
                updatedUser.setContact_info(user.getContact_info());
            }
            updatedUser.setStatus(user.isStatus()); // Always update status since it's a boolean

            return userRepo.save(updatedUser);
        } else {
            throw new RuntimeException("User not found with id: " + user.getId());
        }
    }

    @Override
    public boolean delete(long id) {
        Optional<usersModel> existingUser = userRepo.findById(id);
        if (existingUser.isPresent()) {
            userRepo.delete(existingUser.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public usersModel fetchById(long id) {
        Optional<usersModel> user = userRepo.findById(id);
        return user.orElse(null);
    }

    @Override
    public usersModel fetchByEmail(String email) {
        return null;
    }

    @Override
    public usersModel updateStatus(usersModel user, int status) {
        boolean statusbool = (status == 1) ? true : false;
        Optional<usersModel> existingUser = userRepo.findById(user.getId());
        if (existingUser.isPresent()) {
            usersModel updateduser = existingUser.get();
            updateduser.setStatus(statusbool);
            return userRepo.save(updateduser);
        } else {
            throw new RuntimeException("User not found with id: " + user.getId());
        }
    }

    @Override
    public List<usersModel> fetchAllUsers() {
        return userRepo.findAll();
    }
}
