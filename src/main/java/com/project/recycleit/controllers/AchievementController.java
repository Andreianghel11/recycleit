package com.project.recycleit.controllers;

import com.project.recycleit.dtos.AchievementCreateDto;
import com.project.recycleit.dtos.AchievementDto;
import com.project.recycleit.services.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addAchievement(@RequestBody AchievementCreateDto achievementCreateDto) {
        achievementService.addAchievement(achievementCreateDto);
    }

    @DeleteMapping("/deleteAchievement/{achievementId}")
    public void deleteAchievement(@PathVariable Long achievementId) {
        achievementService.deleteAchievement(achievementId);
    }

}
