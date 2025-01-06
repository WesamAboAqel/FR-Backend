package com.Abood.Project.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "authorizedperson")
public class AuthorizedPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuthID")
    private Long authorizedID;

    @Column(name = "name")
    private String name;

    @Lob
    private byte[] photo;
    private LocalDateTime addedAt;

    // Getters and Setters
    public Long getAuthorizedID() {
        return authorizedID;
    }

    public void setAuthorizedID(Long authorizedID) {
        this.authorizedID = authorizedID;
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

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }
}
