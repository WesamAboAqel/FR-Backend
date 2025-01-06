package com.Abood.Project.Service;

import com.Abood.Project.Entity.Admin;
import com.Abood.Project.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Optional<Admin> getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }



    public Admin createAdmin(Admin admin) {
        validateAdmin(admin);
        if (adminRepository.existsByEmail(admin.getEmail())) {
            throw new IllegalArgumentException("Email is already registered.");
        }
        admin.setLastLogin(null);
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        validateAdmin(updatedAdmin);
        Admin existingAdmin = adminRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Admin not found with ID: " + id));
        existingAdmin.setName(updatedAdmin.getName());
        existingAdmin.setEmail(updatedAdmin.getEmail());
        existingAdmin.setPassword(updatedAdmin.getPassword());
        return adminRepository.save(existingAdmin);
    }

    public void deleteAdmin(Long id) {
        if (!adminRepository.existsById(id)) {
            throw new IllegalArgumentException("Admin not found with ID: " + id);
        }
        adminRepository.deleteById(id);
    }

    public void updateLastLogin(Long id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Admin not found with ID: " + id));
        admin.setLastLogin(LocalDateTime.now());
        adminRepository.save(admin);
    }

    private void validateAdmin(Admin admin) {
        if (admin.getName() == null || admin.getName().isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (admin.getEmail() == null || admin.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required.");
        }
        if (!admin.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (admin.getPassword() == null || admin.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password is required.");
        }
    }
}
