package com.project.recycleit.services;

import com.project.recycleit.beans.WasteItem;
import com.project.recycleit.dtos.WasteItemDto;
import com.project.recycleit.mappers.WasteItemMapper;
import com.project.recycleit.repositories.WasteItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WasteItemService {
    @Autowired
    private WasteItemRepository wasteItemRepository;

    public void addWasteItem(WasteItemDto wasteItemDto) {
        wasteItemRepository.save(WasteItemMapper.toWasteItem(wasteItemDto));
    }

    public WasteItemDto getWasteItem(Long wasteItemId) {
        Optional<WasteItem> wasteItem = wasteItemRepository.findById(wasteItemId);
        if (wasteItem.isPresent()) {
            return WasteItemMapper.toWasteItemDto(wasteItem.get());
        } else {
            throw new IllegalArgumentException("Waste item not found");
        }
    }
}
