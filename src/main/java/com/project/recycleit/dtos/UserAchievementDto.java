package com.project.recycleit.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.recycleit.beans.Achievement;
import com.project.recycleit.beans.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class UserAchievementDto {
    @JsonProperty
    private final Long userAchievementId;

    @JsonProperty
    private final Achievement achievement;

    @JsonProperty
    private final int progress;

    @JsonProperty
    private final boolean isCompleted;

    @JsonProperty
    private final Date timestamp;

    public UserAchievementDto(Long userAchievementId, Achievement achievement, Date timestamp, int progress, boolean isCompleted) {
        this.userAchievementId = userAchievementId;
        this.achievement = achievement;
        this.timestamp = timestamp;
        this.progress = progress;
        this.isCompleted = isCompleted;
    }

    public Long getUserAchievementId() {
        return userAchievementId;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public int getProgress() {
        return progress;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
