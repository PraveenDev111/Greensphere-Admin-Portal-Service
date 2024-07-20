package com.greensphere.admin_portal_service.model;

public class UserRoleRequest {
    private long userId;
    private String role;

    // Getters and Setters
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
