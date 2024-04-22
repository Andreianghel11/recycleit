package com.project.recycleit.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.recycleit.beans.Achievement;
import com.project.recycleit.beans.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class UserAchievementCreateDto {
    @JsonProperty
    private final Long achievementId;

    public UserAchievementCreateDto() {
        this.achievementId = null;
    }

    public UserAchievementCreateDto(Long achievementId) {
        this.achievementId = achievementId;
    }

    public Long getAchievementId() {
        return achievementId;
    }
}
