package com.Abood.Project.Controller;

import com.Abood.Project.Service.UnauthorizedPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/access/unauthorized")
@CrossOrigin(origins = "*")
public class UnauthorizedAccessController {

    @Autowired
    private UnauthorizedPersonService unauthorizedPersonService;

    @GetMapping("/get")
    public ResponseEntity<List<String>> getUnauthorizedNames() {
        return ResponseEntity.ok(unauthorizedPersonService.getAllUnauthorizedNames());
    }
} 