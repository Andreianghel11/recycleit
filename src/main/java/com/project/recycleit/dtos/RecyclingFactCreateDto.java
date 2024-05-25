package com.project.recycleit.dtos;

public class RecyclingFactCreateDto {
    private final String wasteItemName;

    private final String fact;

    public RecyclingFactCreateDto(String wasteItemName, String fact) {
        this.wasteItemName = wasteItemName;
        this.fact = fact;
    }

    public String getWasteItemName() {
        return wasteItemName;
    }

    public String getFact() {
        return fact;
    }
}
