package com.Abood.Project.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "unauthorizedperson")
public class UnauthorizedPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UnAuthID")
    private Long unauthorizedID;

    @Column(name = "name")
    private String name;

    @Lob
    private byte[] photo;
    private LocalDateTime detectedAt;

    // Getters and Setters
    public Long getUnauthorizedID() {
        return unauthorizedID;
    }

    public void setUnauthorizedID(Long unauthorizedID) {
        this.unauthorizedID = unauthorizedID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }
}
