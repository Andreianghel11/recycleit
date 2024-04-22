package com.project.recycleit.services;

import com.project.recycleit.beans.Achievement;
import com.project.recycleit.dtos.AchievementCreateDto;
import com.project.recycleit.dtos.AchievementDto;
import com.project.recycleit.exceptionHandler.ItemNotFoundException;
import com.project.recycleit.mappers.AchievementMapper;
import com.project.recycleit.repositories.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AchievementService {
    @Autowired
    private AchievementRepository achievementRepository;

    public List<AchievementDto> getAllAchievements() {
        return achievementRepository.findAll().stream().map(AchievementMapper::toAchievementDto).toList();
    }

    public void addAchievement(AchievementCreateDto achievementCreateDto) {
        Achievement achievement = AchievementMapper.toAchievement(achievementCreateDto);
        achievementRepository.save(achievement);
    }

    public void deleteAchievement(Long achievementId) {
        if (!achievementRepository.existsById(achievementId)) {
            throw new ItemNotFoundException("Item not found");
        }
        achievementRepository.deleteById(achievementId);
    }

    public void updateAchievement(Long achievementId, AchievementCreateDto achievementCreateDto) {
        Optional<Achievement> achievementOptional = achievementRepository.findById(achievementId);
        if (achievementOptional.isEmpty()) {
            throw new ItemNotFoundException("Item not found");
        } else {
            Achievement achievement = achievementOptional.get();
            achievement.setName(achievementCreateDto.getName());
            achievement.setDescription(achievementCreateDto.getDescription());
            achievement.setIcon_path(achievementCreateDto.getIcon_path());
            achievementRepository.save(achievement);
        }
    }
}
