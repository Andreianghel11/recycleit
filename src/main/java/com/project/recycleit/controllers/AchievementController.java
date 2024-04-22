package com.project.recycleit.controllers;

import com.project.recycleit.dtos.AchievementCreateDto;
import com.project.recycleit.dtos.AchievementDto;
import com.project.recycleit.services.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achievement")
@PreAuthorize("hasRole('ADMIN')")
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    @GetMapping("/getAllAchievements")
    public List<AchievementDto> getAllAchievements() {
        return achievementService.getAllAchievements();
    }

    @PostMapping("/addAchievement")
    public ResponseEntity<String> addAchievement(@RequestBody AchievementCreateDto achievementCreateDto) {
        achievementService.addAchievement(achievementCreateDto);
        return ResponseEntity.ok("Achievement added successfully.");
    }

    @DeleteMapping("/deleteAchievement/{achievementId}")
    public ResponseEntity<String> deleteAchievement(@PathVariable Long achievementId) {
        achievementService.deleteAchievement(achievementId);
        return ResponseEntity.ok("Achievement deleted successfully.");
    }

}
