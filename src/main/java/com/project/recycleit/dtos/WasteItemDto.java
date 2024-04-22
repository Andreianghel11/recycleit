package com.project.recycleit.dtos;

public class WasteItemDto {
    private final Long wasteItemId;
    private final String name;
    private final String recycleColor;
    private final String recycleInfo;

    public WasteItemDto(Long wasteItemId, String name, String recycleColor, String recycleInfo) {
        this.wasteItemId = wasteItemId;
        this.name = name;
        this.recycleColor = recycleColor;
        this.recycleInfo = recycleInfo;
    }

    public Long getWasteItemId() {
        return wasteItemId;
    }

    public String getName() {
        return name;
    }

    public String getRecycleColor() {
        return recycleColor;
    }

    public String getRecycleInfo() {
        return recycleInfo;
    }
}
