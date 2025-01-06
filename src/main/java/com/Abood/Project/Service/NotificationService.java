package com.Abood.Project.Service;

import com.Abood.Project.Entity.Notification;
import com.Abood.Project.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    public Notification saveNotification(Notification notification) {
        return repository.save(notification);
    }

    public void deleteNotificationsByType(String type) {
        repository.deleteByType(type);
    }

    public List<Notification> findNotificationsByPerson(Long personId) {
        return repository.findByPerson_AuthorizedID(personId);
    }

    public List<Notification> findNotificationsByType(String type) {
        return repository.findByType(type);
    }

    public List<Notification> findNotificationsAfterDate(LocalDateTime date) {
        return repository.findByCreatedAtAfter(date);
    }
}
