package com.project.recycleit.mappers;

import com.project.recycleit.beans.RecyclingHistory;
import com.project.recycleit.dtos.RecyclingHistoryCreateDto;

public class RecyclingHistoryMapper {
    public static RecyclingHistory toRecyclingHistory(RecyclingHistoryCreateDto recyclingHistoryCreateDto) {
        return new RecyclingHistory(recyclingHistoryCreateDto.getQuantity());
    }

//    public static RecyclingHistoryDto toRecyclingHistoryDto(RecyclingHistory recyclingHistory) {
//        return new RecyclingHistoryDto(recyclingHistory.getRecyclingHistoryId(), recyclingHistory.getWasteItemId(), recyclingHistory.getQuantity());
//    }
}
