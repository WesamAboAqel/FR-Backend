package com.Abood.Project.Controller;

import com.Abood.Project.Entity.AccessLog;
import com.Abood.Project.Entity.Admin;
import com.Abood.Project.Service.AccessLogService;
import com.Abood.Project.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AccessLogService accessLogService;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    // Signup endpoint
    @PostMapping("/signup")
    public ResponseEntity<Admin> signup(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.createAdmin(admin);
        return ResponseEntity.ok(createdAdmin);
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<Map<String, Boolean>> login(@RequestBody Admin admin) {
        logger.info("Login attempt - Name: {}", admin.getName());

        Optional<Admin> existingAdminOpt = adminService.getAllAdmins().stream()
                .filter(a -> a.getName().equals(admin.getName()))
                .findFirst();

        AccessLog accessLog = new AccessLog();
        accessLog.setAccessTime(LocalDateTime.now());
        accessLog.setAccessGranted(existingAdminOpt.isPresent() && existingAdminOpt.get().getPassword().equals(admin.getPassword()));

        accessLog.setAccountType("admin");
        accessLog.setPersonName(admin.getName());

        if (accessLog.getAccessGranted()) {
            logger.info("Login successful - Name: {}", existingAdminOpt.get().getName());
            accessLogService.saveAccessLog(accessLog);
            return ResponseEntity.ok(Map.of("success", true));
        } else {
            logger.warn("Login failed - Name: {}", admin.getName());
            accessLog.setAccessGranted(false);
            accessLogService.saveAccessLog(accessLog);
            return ResponseEntity.status(404).body(Map.of("success", false));
        }
    }
}
