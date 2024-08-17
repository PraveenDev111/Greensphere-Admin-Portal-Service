package com.greensphere.admin_portal_service.service;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greensphere.admin_portal_service.model.CustomUserDetails;
import com.greensphere.admin_portal_service.model.usersModel;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final userService userService; // Inject your user service

    public CustomUserDetailsService(userService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usersModel user = userService.fetchByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user.getId(), user.getUsername(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRole()));
    }
}
