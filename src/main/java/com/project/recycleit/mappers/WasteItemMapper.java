package com.project.recycleit.mappers;

import com.project.recycleit.beans.WasteItem;
import com.project.recycleit.dtos.WasteItemCreateDto;
import com.project.recycleit.dtos.WasteItemDto;

public class WasteItemMapper {
    public static WasteItemDto toWasteItemDto(WasteItem wasteItem) {
        return new WasteItemDto(wasteItem.getWasteItemId(), wasteItem.getName(), wasteItem.getRecycleColor(), wasteItem.getRecycleInfo());
    }

    public static WasteItem toWasteItem(WasteItemDto wasteItemDto) {
        return new WasteItem(wasteItemDto.getWasteItemId(), wasteItemDto.getName(), wasteItemDto.getRecycleColor(), wasteItemDto.getRecycleInfo());
    }

    public static WasteItem toWasteItem(WasteItemCreateDto wasteItemCreateDto) {
        return new WasteItem(wasteItemCreateDto.getName(), wasteItemCreateDto.getRecycleColor(), wasteItemCreateDto.getRecycleInfo());
    }

    public static WasteItemCreateDto toWasteItemCreateDto(WasteItem wasteItem) {
        return new WasteItemCreateDto(wasteItem.getWasteItemId(), wasteItem.getName(), wasteItem.getRecycleColor(), wasteItem.getRecycleInfo());
    }
}
