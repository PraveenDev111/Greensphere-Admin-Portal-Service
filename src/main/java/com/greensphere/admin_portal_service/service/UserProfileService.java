package com.greensphere.admin_portal_service.service;

import com.greensphere.admin_portal_service.model.UserProfileModel;

public interface UserProfileService {
    UserProfileModel insert(UserProfileModel userProfile);

    UserProfileModel update(UserProfileModel userProfile);

    boolean delete(int userId);

    UserProfileModel fetchById(int userId);

    UserProfileModel fetchByEmail(String email);
}
