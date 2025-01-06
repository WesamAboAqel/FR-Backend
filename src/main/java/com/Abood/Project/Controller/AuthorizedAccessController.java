package com.Abood.Project.Controller;

import com.Abood.Project.Service.AuthorizedPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/access/authorized")
@CrossOrigin(origins = "*")
public class AuthorizedAccessController {

    @Autowired
    private AuthorizedPersonService authorizedPersonService;

    @GetMapping("/get")
    public ResponseEntity<List<String>> getAuthorizedNames() {
        return ResponseEntity.ok(authorizedPersonService.getAllAuthorizedNames());
    }
} 