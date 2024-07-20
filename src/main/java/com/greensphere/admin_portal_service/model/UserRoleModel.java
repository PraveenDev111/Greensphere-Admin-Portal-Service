package com.greensphere.admin_portal_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_roles", uniqueConstraints = { @UniqueConstraint(columnNames = "user_id") })
public class UserRoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private usersModel user;

    @Column(nullable = false)
    private String role;

    // Getters
    public long getId() {
        return id;
    }

    public usersModel getUser() {
        return user;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setUser(usersModel user) {
        this.user = user;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
