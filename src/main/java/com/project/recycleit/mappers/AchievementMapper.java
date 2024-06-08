package com.project.recycleit.mappers;

import com.project.recycleit.beans.Achievement;
import com.project.recycleit.dtos.AchievementCreateDto;
import com.project.recycleit.dtos.AchievementDto;

public class AchievementMapper {
    public static AchievementDto toAchievementDto(Achievement achievement) {
        return new AchievementDto(achievement);
    }

    public static Achievement toAchievement(AchievementCreateDto achievementCreateDto) {
        return new Achievement(achievementCreateDto.getName(), achievementCreateDto.getDescription(),
                 achievementCreateDto.getTarget(), achievementCreateDto.getWasteType());
    }
}
