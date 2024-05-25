package com.project.recycleit.mappers;

import com.project.recycleit.beans.RecyclingFact;
import com.project.recycleit.beans.WasteItem;
import com.project.recycleit.dtos.RecyclingFactCreateDto;
import com.project.recycleit.services.WasteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecyclingFactMapper {
    public static RecyclingFact toRecyclingFact(RecyclingFactCreateDto recyclingFactCreateDto, WasteItem wasteItem) {
        return new RecyclingFact(wasteItem, recyclingFactCreateDto.getFact());
    }
}
