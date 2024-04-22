package com.project.recycleit.dtos;

public class RecyclingHistoryCreateDto {
    private final Long wasteItemId;

    private final int quantity;


    public RecyclingHistoryCreateDto(Long wasteItemId, int quantity) {
        this.wasteItemId = wasteItemId;
        this.quantity = quantity;
    }

    public Long getWasteItemId() {
        return wasteItemId;
    }

    public int getQuantity() {
        return quantity;
    }
}
