package com.project.recycleit.beans;

import jakarta.persistence.*;

@Entity
@Table(name="waste_items")
public class WasteItem {

    @Id
    @GeneratedValue
    @Column(name="waste_item_id")
    private Long wasteItemId;

    @Column(name="name")
    private String name;

    @Column(name="recycle_color")
    private String recycleColor;

    @Column(name="recycle_info")
    private String recycleInfo;



    public WasteItem() {
    }

    public WasteItem(Long wasteItemId, String name, String recycleColor, String recycleInfo) {
        this.wasteItemId = wasteItemId;
        this.name = name;
        this.recycleColor = recycleColor;
        this.recycleInfo = recycleInfo;
    }

    public WasteItem(String name, String recycleColor, String recycleInfo) {
        this.name = name;
        this.recycleColor = recycleColor;
        this.recycleInfo = recycleInfo;
    }

    public Long getWasteItemId() {
        return wasteItemId;
    }

    public void setWasteItemId(Long wasteItemId) {
        this.wasteItemId = wasteItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecycleColor() {
        return recycleColor;
    }

    public void setRecycleColor(String recycleColor) {
        this.recycleColor = recycleColor;
    }

    public String getRecycleInfo() {
        return recycleInfo;
    }

    public void setRecycleInfo(String recycleInfo) {
        this.recycleInfo = recycleInfo;
    }
}
