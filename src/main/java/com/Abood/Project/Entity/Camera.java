package com.Abood.Project.Entity;

import jakarta.persistence.*;

@Entity
public class Camera {
    @Id
    private String cameraID;
    private String location;
    private String status;

    // Getters and Setters
    public String getCameraID() {
        return cameraID;
    }

    public void setCameraID(String cameraID) {
        this.cameraID = cameraID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
