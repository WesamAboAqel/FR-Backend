package com.Abood.Project.Repository;

import com.Abood.Project.Entity.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface AccessLogRepository extends JpaRepository<AccessLog, String> {
    // Find all AccessLogs for a specific Camera
    List<AccessLog> findByCamera_CameraID(String cameraID);

    // Count the number of access attempts where access was granted
    long countByAccessGrantedTrue();

    // Find all AccessLogs within a specific time range
    List<AccessLog> findByAccessTimeBetween(LocalDateTime start, LocalDateTime end);
}
