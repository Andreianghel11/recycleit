package com.project.recycleit.services;

import com.project.recycleit.beans.RecyclingFact;
import com.project.recycleit.beans.WasteItem;
import com.project.recycleit.dtos.RecyclingFactCreateDto;
import com.project.recycleit.dtos.WasteItemDto;
import com.project.recycleit.mappers.RecyclingFactMapper;
import com.project.recycleit.mappers.WasteItemMapper;
import com.project.recycleit.repositories.RecyclingFactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RecyclingFactService {
    @Autowired
    RecyclingFactRepository recyclingFactRepository;

    @Autowired
    WasteItemService wasteItemService;

    public void addRecyclingFact(RecyclingFactCreateDto recyclingFactCreateDto) {
        WasteItemDto wasteItemDto = wasteItemService.getWasteItemByName(recyclingFactCreateDto.getWasteItemName());
        WasteItem wasteItem = WasteItemMapper.toWasteItem(wasteItemDto);

        recyclingFactRepository.save(RecyclingFactMapper.toRecyclingFact(recyclingFactCreateDto, wasteItem));
    }

    public List<RecyclingFact> getAllRecyclingFacts() {
        return recyclingFactRepository.findAll();
    }

    public RecyclingFact getRandomRecyclingFactByName(String wasteItemName) {
        List<RecyclingFact> recyclingFacts = recyclingFactRepository.findAll();
        List<RecyclingFact> recyclingFactsByWasteItemName = recyclingFacts.stream()
                .filter(recyclingFact -> recyclingFact.getWasteItem().getName().equals(wasteItemName)).toList();

        if (recyclingFactsByWasteItemName.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(recyclingFactsByWasteItemName.size());

        return recyclingFactsByWasteItemName.get(randomIndex);
    }
}
