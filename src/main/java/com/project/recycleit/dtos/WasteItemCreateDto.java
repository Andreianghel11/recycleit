package com.project.recycleit.dtos;

public class WasteItemCreateDto {
    private final String name;
    private final String recycleColor;
    private final String recycleInfo;

    public WasteItemCreateDto(Long wasteItemId, String name, String recycleColor, String recycleInfo) {
        this.name = name;
        this.recycleColor = recycleColor;
        this.recycleInfo = recycleInfo;
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
