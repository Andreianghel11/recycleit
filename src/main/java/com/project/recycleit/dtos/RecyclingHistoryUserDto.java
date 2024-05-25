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

    public RecyclingHistoryUserDto(WasteItem wasteItem, int quantity, Date timestamp) {
        this.wasteItem = wasteItem;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    public RecyclingHistoryUserDto(RecyclingHistory recyclingHistory) {
        this.wasteItem = recyclingHistory.getWasteItem();
        this.quantity = recyclingHistory.getQuantity();
        this.timestamp = recyclingHistory.getTimestamp();
    }

}
