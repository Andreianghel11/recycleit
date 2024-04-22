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
    private final UserDto user;

    @JsonProperty
    private final Achievement achievement;

    @JsonProperty
    private final Date timestamp;

    public UserAchievementDto(Long userAchievementId, User user, Achievement achievement, Date timestamp) {
        this.userAchievementId = userAchievementId;
        this.user = new UserDto(user);
        this.achievement = achievement;
        this.timestamp = timestamp;
    }

    public Long getUserAchievementId() {
        return userAchievementId;
    }

    public UserDto getUser() {
        return user;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
