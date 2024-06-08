package com.project.recycleit.controllers;

import com.project.recycleit.beans.UserAchievement;
import com.project.recycleit.dtos.UserAchievementCreateDto;
import com.project.recycleit.dtos.UserAchievementDto;
import com.project.recycleit.services.UserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userAchievements")
public class UserAchievementController {
    @Autowired
    UserAchievementService userAchievementService;

    @PostMapping("/addUserAchievement")
    public ResponseEntity<String> addUserAchievement(@RequestBody UserAchievementCreateDto userAchievementCreateDto) {
        userAchievementService.addUserAchievement(userAchievementCreateDto);
        return ResponseEntity.ok("User Achievement added successfully.");
    }

    @GetMapping("/getAllUserAchievements")
    public List<UserAchievementDto> getAllUserAchievements() {
        return userAchievementService.getAllUserAchievements();
    }

}
