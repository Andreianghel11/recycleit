package com.project.recycleit.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.recycleit.beans.Achievement;
import com.project.recycleit.utils.WasteTypes;
import jakarta.persistence.Column;

public class AchievementDto {
    @JsonProperty
    private final Long achievementId;

    @JsonProperty
    private final String name;

    @JsonProperty
    private final String description;

    @JsonProperty
    private final int target;

    @JsonProperty
    private final String wasteType;

    public AchievementDto(Long achievementId, String name, String description, int target, String wasteType) {
        this.achievementId = achievementId;
        this.name = name;
        this.description = description;
        this.target = target;
        this.wasteType = wasteType;
    }

    public AchievementDto(Achievement achievement) {
        this.achievementId = achievement.getAchievementId();
        this.name = achievement.getName();
        this.description = achievement.getDescription();
        this.target = achievement.getTarget();
        this.wasteType = achievement.getWasteType();
    }
}
