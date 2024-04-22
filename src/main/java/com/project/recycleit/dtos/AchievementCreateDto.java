package com.project.recycleit.dtos;

import jakarta.persistence.Column;

public class AchievementCreateDto {
    private final String name;

    private final String description;

    private final String icon_path;

    public AchievementCreateDto(String name, String description, String icon_path) {
        this.name = name;
        this.description = description;
        this.icon_path = icon_path;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon_path() {
        return icon_path;
    }
}
