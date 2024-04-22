package com.project.recycleit.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.recycleit.beans.RecyclingHistory;
import com.project.recycleit.beans.User;
import com.project.recycleit.beans.WasteItem;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Date;

public class RecyclingHistoryDto {

    @JsonProperty
    private final Long recyclingHistoryId;

    @JsonProperty
    private final UserDto user;

    @JsonProperty
    private final WasteItem wasteItem;

    @JsonProperty
    private final int quantity;

    @JsonProperty
    private final Date timestamp;

    public RecyclingHistoryDto(Long recyclingHistoryId, UserDto user, WasteItem wasteItem, int quantity, Date timestamp) {
        this.recyclingHistoryId = recyclingHistoryId;
        this.user = user;
        this.wasteItem = wasteItem;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    public RecyclingHistoryDto(RecyclingHistory recyclingHistory) {
        this.recyclingHistoryId = recyclingHistory.getRecyclingHistoryId();
        this.user = new UserDto(recyclingHistory.getUser());
        this.wasteItem = recyclingHistory.getWasteItem();
        this.quantity = recyclingHistory.getQuantity();
        this.timestamp = recyclingHistory.getTimestamp();
    }
}
