package com.project.recycleit.services;

import com.project.recycleit.beans.Achievement;
import com.project.recycleit.beans.User;
import com.project.recycleit.beans.UserAchievement;
import com.project.recycleit.dtos.UserAchievementCreateDto;
import com.project.recycleit.dtos.UserAchievementDto;
import com.project.recycleit.exceptionHandler.ItemNotFoundException;
import com.project.recycleit.exceptionHandler.UserNotFoundException;
import com.project.recycleit.mappers.UserAchievementMapper;
import com.project.recycleit.repositories.AchievementRepository;
import com.project.recycleit.repositories.UserAchievementRepository;
import com.project.recycleit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAchievementService {
    @Autowired
    UserAchievementRepository userAchievementRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AchievementRepository achievementRepository;

    public void addUserAchievement(UserAchievementCreateDto userAchievementCreateDto) {
        Long achievementId = userAchievementCreateDto.getAchievementId();
        UserAchievement userAchievement = new UserAchievement();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> user = userRepository.findByEmail(username);

        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        } else {
            userAchievement.setUser(user.get());
            Optional<Achievement> achievement = achievementRepository.findById(achievementId);
            if (achievement.isEmpty()) {
                throw new ItemNotFoundException("Achievement not found");
            } else {
                userAchievement.setAchievement(achievement.get());
                userAchievementRepository.save(userAchievement);
            }
        }
    }

    public void addUserAchievement(User user, Achievement achievement) {
        UserAchievement userAchievement = new UserAchievement(user, achievement);
        userAchievementRepository.save(userAchievement);
    }

    public void createNewUserAchievements(User user) {
        List<Achievement> achievements = achievementRepository.findAll();

        for (Achievement achievement : achievements) {
            UserAchievement userAchievement = new UserAchievement(user, achievement);
            userAchievementRepository.save(userAchievement);
        }
    }

    public void updateUserAchievementsForWasteItem(String item) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> user = userRepository.findByEmail(username);

        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        } else {
            Optional<List<UserAchievement>> userAchievements = userAchievementRepository.findAllByUserUserId(user.get().getUserId());
            if (userAchievements.isEmpty()) {
                throw new ItemNotFoundException("User achievements not found");
            } else {
                List<UserAchievement> userAchievementsList = userAchievements.get();
                for (UserAchievement userAchievement : userAchievementsList) {
                    if (!userAchievement.getIsCompleted() &&
                            (userAchievement.getAchievement().getWasteType().equals(item)
                                    || userAchievement.getAchievement().getWasteType().equals("Anything"))) {
                        userAchievement.setProgress(userAchievement.getProgress() + 1);
                        if (userAchievement.getProgress() == userAchievement.getAchievement().getTarget()) {
                           userAchievement.setIsCompleted(true);
                           userAchievement.setTimestamp(new java.util.Date());
                        }
                        userAchievementRepository.save(userAchievement);
                    }
                }
            }
        }
    }

    public List<UserAchievementDto> getAllUserAchievements() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> user = userRepository.findByEmail(username);

        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        } else {
            Optional<List<UserAchievement>> userAchievements = userAchievementRepository.findAllByUserUserId(user.get().getUserId());
            if (userAchievements.isEmpty()) {
                throw new ItemNotFoundException("User achievements not found");
            } else {
                return userAchievements.get().stream().map(UserAchievementMapper::toUserAchievementDto).sorted(this::sortAchievements).toList();
            }
        }
    }

    private int sortAchievements(UserAchievementDto a, UserAchievementDto b) {
        if (a.getIsCompleted() != b.getIsCompleted()) {
            return Boolean.compare(b.getIsCompleted(), a.getIsCompleted());
        } else if (a.getIsCompleted()) {
            return b.getTimestamp().compareTo(a.getTimestamp());
        } else {
            return Integer.compare(b.getProgress(), a.getProgress());
        }
    }
}
