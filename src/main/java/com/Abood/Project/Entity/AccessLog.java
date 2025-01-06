package com.Abood.Project.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="accesslog")
public class AccessLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logID;

    @ManyToOne
    @JoinColumn(name = "cameraID")
    private Camera camera;

    private LocalDateTime accessTime;
    private Boolean accessGranted;

    // New fields
    @Column(name = "accounttype")
    private String accountType;

    @Column(name = "name")
    private String personName;

    // Getters and Setters
    public Long getLogID() {
        return logID;
    }

    public void setLogID(Long logID) {
        this.logID = logID;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public LocalDateTime getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(LocalDateTime accessTime) {
        this.accessTime = accessTime;
    }

    public Boolean getAccessGranted() {
        return accessGranted;
    }

    public void setAccessGranted(Boolean accessGranted) {
        this.accessGranted = accessGranted;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
