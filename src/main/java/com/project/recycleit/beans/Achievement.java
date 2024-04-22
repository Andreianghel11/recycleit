package com.project.recycleit.beans;

import jakarta.persistence.*;

@Entity
@Table(name="achievements")
public class Achievement {

    @Id
    @GeneratedValue
    @Column(name="achievement_id")
    private Long achievementId;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="icon_path")
    private String icon_path;

    public Achievement() {
    }

    public Achievement(String name, String description, String icon_path) {
        this.name = name;
        this.description = description;
        this.icon_path = icon_path;
    }

    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon_path() {
        return icon_path;
    }

    public void setIcon_path(String icon_path) {
        this.icon_path = icon_path;
    }
}
