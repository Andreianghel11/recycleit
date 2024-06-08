package com.project.recycleit.beans;

import com.project.recycleit.utils.WasteTypes;
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

    @Column(name="target")
    private int target;

    @Column(name="waste_type")
    private String wasteType;

    public Achievement() {
    }

    public Achievement(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Achievement(String name, String description, int target, String wasteType) {
        this.name = name;
        this.description = description;
        this.target = target;
        this.wasteType = wasteType;
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

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }
}
