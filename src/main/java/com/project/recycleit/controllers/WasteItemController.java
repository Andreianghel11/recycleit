package com.project.recycleit.controllers;

import com.project.recycleit.dtos.WasteItemCreateDto;
import com.project.recycleit.dtos.WasteItemDto;
import com.project.recycleit.services.WasteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wasteItem")
@PreAuthorize("hasRole('ADMIN')")
public class WasteItemController {
    @Autowired
    private WasteItemService wasteItemService;

    @PostMapping("/addWasteItem")
    public ResponseEntity<String> addWasteItem(@RequestBody WasteItemCreateDto wasteItemCreateDto) {
        wasteItemService.addWasteItem(wasteItemCreateDto);
        return ResponseEntity.ok("Waste item added successfully.");
    }

    @GetMapping("/getAllWasteItems")
    @ResponseBody
    public ResponseEntity<List<WasteItemDto>> getAllWasteItems() {
        List<WasteItemDto> wasteItemDtos = wasteItemService.getAllWasteItems();
        return ResponseEntity.ok(wasteItemDtos);
    }

    @GetMapping("/getWasteItem/{wasteItemId}")
    @ResponseBody
    public ResponseEntity<WasteItemDto> getWasteItem(@PathVariable Long wasteItemId) {
        WasteItemDto wasteItemDto = wasteItemService.getWasteItem(wasteItemId);
        return ResponseEntity.ok(wasteItemDto);
    }

    @DeleteMapping("/deleteWasteItem/{wasteItemId}")
    public ResponseEntity<String > deleteWasteItem(@PathVariable Long wasteItemId) {
        wasteItemService.deleteWasteItem(wasteItemId);
        return ResponseEntity.ok("Waste item deleted successfully.");
    }
}
