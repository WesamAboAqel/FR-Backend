package com.Abood.Project.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminid")  // Ensure the column name is exactly 'adminid'
    private Long adminID;

    @Column(name = "name")  // Ensure the column name is exactly 'name'
    private String name;

    @Column(name = "email")  // Ensure the column name is exactly 'email'
    private String email;

    @Column(name = "password")  // Ensure the column name is exactly 'password_hash'
    private String password;

    @Column(name = "lastlogin")  // Ensure the column name is exactly 'last_login'
    private LocalDateTime lastLogin;

    // Getters and Setters
    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
