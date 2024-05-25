package com.project.recycleit.mappers;

import com.project.recycleit.beans.RecyclingHistory;
import com.project.recycleit.dtos.RecyclingHistoryCreateDto;
import com.project.recycleit.dtos.RecyclingHistoryDto;
import com.project.recycleit.dtos.RecyclingHistoryUserDto;

public class RecyclingHistoryMapper {
    public static RecyclingHistory toRecyclingHistory(RecyclingHistoryCreateDto recyclingHistoryCreateDto) {
        return new RecyclingHistory(recyclingHistoryCreateDto.getQuantity());
    }

    public static RecyclingHistoryDto toRecyclingHistoryDto(RecyclingHistory recyclingHistory) {
        return new RecyclingHistoryDto(recyclingHistory);
    }

    public static RecyclingHistoryUserDto toRecyclingHistoryUserDto(RecyclingHistory recyclingHistory) {
        return new RecyclingHistoryUserDto(recyclingHistory);
    }
}
