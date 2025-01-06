package com.Abood.Project.Repository;

import com.Abood.Project.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, String> {
    // Find all Notifications for a specific AuthorizedPerson
    List<Notification> findByPerson_AuthorizedID(Long authorizedID);

    // Find Notifications by type
    List<Notification> findByType(String type);

    // Find Notifications created after a specific date
    List<Notification> findByCreatedAtAfter(LocalDateTime date);

    // Delete Notifications by type
    void deleteByType(String type);
}
