package com.project.recycleit.controllers;

import com.project.recycleit.beans.RecyclingHistory;
import com.project.recycleit.dtos.RecyclingHistoryCreateDto;
import com.project.recycleit.dtos.RecyclingHistoryDto;
import com.project.recycleit.services.RecyclingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recyclingHistory")
public class RecyclingHistoryController {
    @Autowired
    RecyclingHistoryService recyclingHistoryService;

    @PostMapping("/addRecyclingHistory")
    public ResponseEntity<String> addRecyclingHistory(@RequestBody RecyclingHistoryCreateDto recyclingHistoryCreateDto) {
        recyclingHistoryService.addRecyclingHistory(recyclingHistoryCreateDto);
        return ResponseEntity.ok("Recycling History added successfully.");
    }

    @GetMapping("/getRecyclingHistory")
    public List<RecyclingHistoryDto> getRecyclingHistory() {
        return recyclingHistoryService.getRecyclingHistory();
    }
}
