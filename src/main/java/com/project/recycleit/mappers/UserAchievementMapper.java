package com.project.recycleit.mappers;

import com.project.recycleit.beans.UserAchievement;
import com.project.recycleit.dtos.UserAchievementCreateDto;
import com.project.recycleit.dtos.UserAchievementDto;

public class UserAchievementMapper {
    public static UserAchievement toUserAchievement(UserAchievementCreateDto userAchievementCreateDto) {
        return new UserAchievement(userAchievementCreateDto.getAchievementId());
    }

    public static UserAchievementDto toUserAchievementDto(UserAchievement userAchievement) {
        return new UserAchievementDto(userAchievement.getUserAchievementId(), userAchievement.getUser(), userAchievement.getAchievement(), userAchievement.getTimestamp());
    }
}
