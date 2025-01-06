package com.Abood.Project.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    private String notificationID;
    private String message;
    private LocalDateTime createdAt;
    private String type;

    @ManyToOne
    @JoinColumn(name = "personID")
    private AuthorizedPerson person;

    // Getters and Setters
    public String getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(String notificationID) {
        this.notificationID = notificationID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AuthorizedPerson getPerson() {
        return person;
    }

    public void setPerson(AuthorizedPerson person) {
        this.person = person;
    }
}
