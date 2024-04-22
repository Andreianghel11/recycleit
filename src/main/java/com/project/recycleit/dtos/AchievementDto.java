package com.project.recycleit.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.recycleit.beans.Achievement;
import jakarta.persistence.Column;

public class AchievementDto {
    @JsonProperty
    private final Long achievementId;

    @JsonProperty
    private final String name;

    @JsonProperty
    private final String description;

    @JsonProperty
    private final String icon_path;

    public AchievementDto(Long achievementId, String name, String description, String icon_path) {
        this.achievementId = achievementId;
        this.name = name;
        this.description = description;
        this.icon_path = icon_path;
    }

    public AchievementDto(Achievement achievement) {
        this.achievementId = achievement.getAchievementId();
        this.name = achievement.getName();
        this.description = achievement.getDescription();
        this.icon_path = achievement.getIcon_path();
    }
}
