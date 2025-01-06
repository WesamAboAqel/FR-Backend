package com.Abood.Project.Controller;

import com.Abood.Project.Service.FlaggedPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/access/flagged")
@CrossOrigin(origins = "*")
public class FlaggedAccessController {

    @Autowired
    private FlaggedPersonService flaggedPersonService;

    @GetMapping("/get")
    public ResponseEntity<List<String>> getFlaggedNames() {
        return ResponseEntity.ok(flaggedPersonService.getAllFlaggedNames());
    }
} 