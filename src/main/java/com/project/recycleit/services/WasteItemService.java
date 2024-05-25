package com.project.recycleit.services;

import com.project.recycleit.beans.WasteItem;
import com.project.recycleit.dtos.WasteItemCreateDto;
import com.project.recycleit.dtos.WasteItemDto;
import com.project.recycleit.exceptionHandler.ItemNotFoundException;
import com.project.recycleit.mappers.WasteItemMapper;
import com.project.recycleit.repositories.WasteItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WasteItemService {
    @Autowired
    private WasteItemRepository wasteItemRepository;

    public void addWasteItem(WasteItemCreateDto wasteItemCreateDto) {
        wasteItemRepository.save(WasteItemMapper.toWasteItem(wasteItemCreateDto));
    }

    public WasteItemDto getWasteItem(Long wasteItemId) {
        Optional<WasteItem> wasteItem = wasteItemRepository.findById(wasteItemId);
        if (wasteItem.isPresent()) {
            return WasteItemMapper.toWasteItemDto(wasteItem.get());
        } else {
            throw new ItemNotFoundException("Waste item not found");
        }
    }

    public List<WasteItemDto> getAllWasteItems() {
        List<WasteItem> wasteItems = wasteItemRepository.findAll();
        return wasteItems.stream().map(WasteItemMapper::toWasteItemDto).toList();
    }

    public void deleteWasteItem(Long wasteItemId) {
        if (!wasteItemRepository.existsById(wasteItemId)) {
            throw new ItemNotFoundException("Waste item not found");
        } else {
            wasteItemRepository.deleteById(wasteItemId);
        }
    }

    public WasteItemDto getWasteItemByName(String wasteItemName) {
        Optional<WasteItem> wasteItem = wasteItemRepository.findByName(wasteItemName);
        if (wasteItem.isPresent()) {
            return WasteItemMapper.toWasteItemDto(wasteItem.get());
        } else {
            throw new ItemNotFoundException("Waste item not found");
        }
    }


}
