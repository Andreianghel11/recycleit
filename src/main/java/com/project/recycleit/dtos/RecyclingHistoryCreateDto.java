package com.project.recycleit.dtos;

public class RecyclingHistoryCreateDto {
    private final Long wasteItemId;

    private final int quantity;

    private final String image;


    public RecyclingHistoryCreateDto(Long wasteItemId, int quantity, String image) {
        this.wasteItemId = wasteItemId;
        this.quantity = quantity;
        this.image = image;
    }

    public Long getWasteItemId() {
        return wasteItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "RecyclingHistoryCreateDto{" +
                "wasteItemId=" + wasteItemId +
                ", quantity=" + quantity +
                ", image='" + image + '\'' +
                '}';
    }
}
