package com.greensphere.admin_portal_service.service;

import com.greensphere.admin_portal_service.model.UserProfileModel;
import com.greensphere.admin_portal_service.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserProfileModel insert(UserProfileModel userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfileModel update(UserProfileModel userProfile) {
        Optional<UserProfileModel> existingUserProfile = userProfileRepository.findById(userProfile.getUserId());
        if (existingUserProfile.isPresent()) {
            UserProfileModel updatedUserProfile = existingUserProfile.get();
            updatedUserProfile.setFirstName(userProfile.getFirstName());
            updatedUserProfile.setLastName(userProfile.getLastName());
            updatedUserProfile.setContactInfo(userProfile.getContactInfo());
            updatedUserProfile.setAddress(userProfile.getAddress());
            return userProfileRepository.save(updatedUserProfile);
        } else {
            throw new RuntimeException("User Profile not found with id: " + userProfile.getUserId());
        }
    }

    @Override
    public boolean delete(int userId) {
        Optional<UserProfileModel> existingUserProfile = userProfileRepository.findById(userId);
        if (existingUserProfile.isPresent()) {
            userProfileRepository.delete(existingUserProfile.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserProfileModel fetchById(int userId) {
        Optional<UserProfileModel> userProfile = userProfileRepository.findById(userId);
        return userProfile.orElse(null);
    }

    @Override
    public UserProfileModel fetchByEmail(String email) {
        // Assuming the repository method is implemented to find by email
        // return userProfileRepository.findByEmail(email);
        return null;
    }
}
