package com.project.recycleit.dtos;

import java.time.LocalDateTime;

public class RecyclingHistoryCreateDto {
    private final Long wasteItemId;

    private final int quantity;

    private final String image;

    private final LocalDateTime timestamp;


    public RecyclingHistoryCreateDto(Long wasteItemId, int quantity, String image, LocalDateTime timestamp) {
        this.wasteItemId = wasteItemId;
        this.quantity = quantity;
        this.image = image;
        this.timestamp = timestamp;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "RecyclingHistoryCreateDto{" +
                "wasteItemId=" + wasteItemId +
                ", quantity=" + quantity +
                ", image='" + image + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
