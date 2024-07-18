package com.greensphere.admin_portal_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_roles")
public class UserRoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private usersModel user;

    @Column(nullable = false)
    private String role;

    public UserRoleModel() {
    }

    public UserRoleModel(usersModel user, String role) {
        this.user = user;
        this.role = role;
    }

}
