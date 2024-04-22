package com.project.recycleit.controllers;

import com.project.recycleit.dtos.WasteItemDto;
import com.project.recycleit.services.WasteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wasteItem")
//@PreAuthorize("hasRole('ADMIN')")
public class WasteItemController {
    @Autowired
    private WasteItemService wasteItemService;

    @PostMapping("/addWasteItem")
    public void addWasteItem(@RequestBody WasteItemDto wasteItemDto) {
        wasteItemService.addWasteItem(wasteItemDto);
    }

    @GetMapping("/getWasteItem/{wasteItemId}")
    @ResponseBody
    public ResponseEntity<WasteItemDto> getWasteItem(@PathVariable Long wasteItemId) {
        WasteItemDto wasteItemDto = wasteItemService.getWasteItem(wasteItemId);
        return ResponseEntity.ok(wasteItemDto);
    }
}
