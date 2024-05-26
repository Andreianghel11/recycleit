package com.project.recycleit.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.recycleit.beans.RecyclingHistory;
import com.project.recycleit.beans.WasteItem;

import java.sql.Date;

public class RecyclingHistoryUserDto {

    @JsonProperty
    private final WasteItem wasteItem;

    @JsonProperty
    private final int quantity;

    @JsonProperty
    private final Date timestamp;

    @JsonProperty
    private final String image;

    public RecyclingHistoryUserDto(WasteItem wasteItem, int quantity, Date timestamp, String image) {
        this.wasteItem = wasteItem;
        this.quantity = quantity;
        this.timestamp = timestamp;
        this.image = image;
    }

    public RecyclingHistoryUserDto(RecyclingHistory recyclingHistory) {
        this.wasteItem = recyclingHistory.getWasteItem();
        this.quantity = recyclingHistory.getQuantity();
        this.timestamp = recyclingHistory.getTimestamp();
        this.image = recyclingHistory.getImage();
    }

}
