package com.project.recycleit.dtos;

import com.project.recycleit.utils.WasteTypes;
import jakarta.persistence.Column;

public class AchievementCreateDto {
    private final String name;

    private final String description;

    private final int target;

    private final String wasteType;

    public AchievementCreateDto(String name, String description, int target, String wasteType) {
        this.name = name;
        this.description = description;
        this.target = target;
        this.wasteType = wasteType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getTarget() {
        return target;
    }

    public String getWasteType() {
        return wasteType;
    }
}
