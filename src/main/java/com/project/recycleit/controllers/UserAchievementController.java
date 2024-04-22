package com.project.recycleit.controllers;

import com.project.recycleit.beans.UserAchievement;
import com.project.recycleit.dtos.UserAchievementCreateDto;
import com.project.recycleit.dtos.UserAchievementDto;
import com.project.recycleit.services.UserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userAchievement")
public class UserAchievementController {
    @Autowired
    UserAchievementService userAchievementService;

    @PostMapping("/addUserAchievement")
    public void addUserAchievement(@RequestBody UserAchievementCreateDto userAchievementCreateDto) {
        userAchievementService.addUserAchievement(userAchievementCreateDto);
    }

    @GetMapping("/getAllUserAchievements")
    public List<UserAchievementDto> getAllUserAchievements() {
        return userAchievementService.getAllUserAchievements();
    }

}
