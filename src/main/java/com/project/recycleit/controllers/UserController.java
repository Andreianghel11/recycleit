package com.project.recycleit.controllers;

import com.project.recycleit.beans.User;
import com.project.recycleit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/connectivity")
    public ResponseEntity<String> testDatabaseConnection() {
        try {
            User user = userRepository.findFirstByUserId(1L);
            if (user != null) {
                return ResponseEntity.ok("Database connectivity test passed!");
            } else {
                return ResponseEntity.ok("Database is connected, but no users found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to connect to the database: " + e.getMessage());
        }
    }

    @GetMapping("/getUserById")
    @ResponseBody
    public ResponseEntity<User> getUserById(@RequestParam("userId") Long userId) {
        try {
            User user = userRepository.findFirstByUserId(userId);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}

