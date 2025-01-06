package com.Abood.Project.Service;

import com.Abood.Project.Entity.AccessLog;
import com.Abood.Project.Repository.AccessLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccessLogService {

    @Autowired
    private AccessLogRepository repository;

    public List<AccessLog> getAllAccessLogs() {
        return repository.findAll();
    }

    public AccessLog saveAccessLog(AccessLog log) {
        return repository.save(log);
    }

    public List<AccessLog> findLogsByCamera(String cameraId) {
        return repository.findByCamera_CameraID(cameraId);
    }

    public List<AccessLog> findLogsInTimeRange(LocalDateTime start, LocalDateTime end) {
        return repository.findByAccessTimeBetween(start, end);
    }
}
