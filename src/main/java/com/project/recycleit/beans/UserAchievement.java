package com.project.recycleit.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="user_achievements")
public class UserAchievement {
    @Id
    @GeneratedValue
    @Column(name="user_achievement_id")
    private Long userAchievementId;

    @JoinColumn(name="user_id")
    @ManyToOne
    @JsonIgnore
    private User user;

    @JoinColumn(name="achievement_id")
    @ManyToOne
    private Achievement achievement;

    @Column(name="earned_at")
    private Date timestamp;

    public UserAchievement() {
        timestamp = new Date(System.currentTimeMillis());
    }

    public UserAchievement(Long userAchievementId) {
        this.userAchievementId = userAchievementId;
    }

    public Long getUserAchievementId() {
        return userAchievementId;
    }

    public void setUserAchievementId(Long userAchievementId) {
        this.userAchievementId = userAchievementId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
