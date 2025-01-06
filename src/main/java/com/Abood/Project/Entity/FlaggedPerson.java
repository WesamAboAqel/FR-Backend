package com.Abood.Project.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flaggedperson")
public class FlaggedPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FlaggedID")
    private Long flaggedID;
    @Column(name = "name")
    private String name;
    @Lob
    private byte[] photo;
    private LocalDateTime flaggedAt;

    // Getters and Setters
    public Long getFlaggedID() {
        return flaggedID;
    }

    public void setFlaggedID(Long flaggedID) {
        this.flaggedID = flaggedID;
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


    public LocalDateTime getFlaggedAt() {
        return flaggedAt;
    }

    public void setFlaggedAt(LocalDateTime flaggedAt) {
        this.flaggedAt = flaggedAt;
    }
}
