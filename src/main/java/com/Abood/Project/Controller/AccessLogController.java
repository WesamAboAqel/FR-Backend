package com.Abood.Project.Controller;

import com.Abood.Project.Entity.AccessLog;
import com.Abood.Project.Service.AccessLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accesslog")
public class AccessLogController {

    @Autowired
    private AccessLogService accessLogService;

    // POST endpoint to save AccessLog
    @PostMapping("/post")
    public ResponseEntity<AccessLog> postAccessLog(@RequestBody AccessLog accessLog) {
        AccessLog savedLog = accessLogService.saveAccessLog(accessLog);
        return ResponseEntity.ok(savedLog); // Return 200 OK with the saved AccessLog
    }

    // GET endpoint to retrieve all AccessLogs
    @GetMapping("/get")
    public ResponseEntity<List<AccessLog>> getAllAccessLogs() {
        List<AccessLog> accessLogs = accessLogService.getAllAccessLogs();
        return ResponseEntity.ok(accessLogs); // Return 200 OK with the list of AccessLogs
    }
} 