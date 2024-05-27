package com.project.recycleit.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.recycleit.beans.RecyclingHistory;
import com.project.recycleit.beans.WasteItem;

import java.sql.Date;
import java.time.LocalDateTime;

public class RecyclingHistoryUserDto {
    @JsonProperty
    private final Long id;

    @JsonProperty
    private final WasteItem wasteItem;

    @JsonProperty
    private final int quantity;

    @JsonProperty
    private final LocalDateTime timestamp;

    @JsonProperty
    private final String image;

    public RecyclingHistoryUserDto(Long id, WasteItem wasteItem, int quantity, LocalDateTime timestamp, String image) {
        this.id = id;
        this.wasteItem = wasteItem;
        this.quantity = quantity;
        this.timestamp = timestamp;
        this.image = image;
    }

    public RecyclingHistoryUserDto(RecyclingHistory recyclingHistory) {
        this.id = recyclingHistory.getRecyclingHistoryId();
        this.wasteItem = recyclingHistory.getWasteItem();
        this.quantity = recyclingHistory.getQuantity();
        this.timestamp = recyclingHistory.getTimestamp();
        this.image = recyclingHistory.getImage();
    }

}
