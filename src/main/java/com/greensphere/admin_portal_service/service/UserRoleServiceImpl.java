package com.greensphere.admin_portal_service.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greensphere.admin_portal_service.model.UserRoleModel;
import com.greensphere.admin_portal_service.model.usersModel;
import com.greensphere.admin_portal_service.repository.UserRoleRepository;
import com.greensphere.admin_portal_service.repository.userRepository;

import jakarta.transaction.Transactional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRoleModel addRoleToUser(usersModel user, String role) {
        // Check if the rolw is one of the following
        final Set<String> ALLOWED_ROLES = Set.of("Admin", "User", "Officer");

        if (!ALLOWED_ROLES.contains(role)) {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
        // Check if a role already exists for the user
        Optional<UserRoleModel> existingRole = userRoleRepository.findByUser(user);

        UserRoleModel userRole;
        if (existingRole.isPresent()) {
            userRole = existingRole.get();
            userRole.setRole(role); // Update existing role
        } else {
            userRole = new UserRoleModel();
            userRole.setUser(user);
            userRole.setRole(role); // Assign new role
        }
        return userRoleRepository.save(userRole);
    }

    @Override
    public List<UserRoleModel> getRolesByUserId(Long userId) {
        Optional<UserRoleModel> userRole = userRoleRepository.findById(userId);
        // Handle the case where userRole is empty (no user found)
        return userRole.map(Collections::singletonList).orElse(Collections.emptyList());
    }

}
