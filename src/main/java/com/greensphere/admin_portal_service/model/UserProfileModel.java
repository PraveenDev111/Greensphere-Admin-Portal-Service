package com.greensphere.admin_portal_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_profiles")
public class UserProfileModel {

    @Id
    @Column(name = "user_id")
    private int userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private usersModel user;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "contact_info", length = 100)
    private String contactInfo;

    @Column(name = "address", length = 255)
    private String address;

    // Constructors, getters, and setters
    // Constructor(s)
    public UserProfileModel() {
    }

    public UserProfileModel(usersModel user, String firstName, String lastName, String contactInfo, String address) {
        this.user = user;
        this.userId = user.getId(); // Set the user_id as the same as UsersModel's id
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
        this.address = address;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public usersModel getUser() {
        return user;
    }

    public void setUser(usersModel user) {
        this.user = user;
        this.userId = user.getId();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
