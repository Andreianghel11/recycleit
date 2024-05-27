package com.project.recycleit.controllers;

import com.project.recycleit.beans.RecyclingHistory;
import com.project.recycleit.dtos.ApiResponse;
import com.project.recycleit.dtos.RecyclingHistoryCreateDto;
import com.project.recycleit.dtos.RecyclingHistoryDto;
import com.project.recycleit.dtos.RecyclingHistoryUserDto;
import com.project.recycleit.services.RecyclingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recyclingHistory")
public class RecyclingHistoryController {
    @Autowired
    RecyclingHistoryService recyclingHistoryService;

    @PostMapping("/addRecyclingHistory")
    public ResponseEntity<ApiResponse> addRecyclingHistory(@RequestBody RecyclingHistoryCreateDto recyclingHistoryCreateDto) {
        recyclingHistoryService.addRecyclingHistory(recyclingHistoryCreateDto);
        ApiResponse response = new ApiResponse("Recycling history added successfully", null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getRecyclingHistory")
    public List<RecyclingHistoryDto> getRecyclingHistory() {
        return recyclingHistoryService.getRecyclingHistory();
    }

    @GetMapping("/getRecyclingHistoryUser")
    public Page<RecyclingHistoryUserDto> getRecyclingHistoryByUser(@RequestParam int page, @RequestParam int size) {
        return recyclingHistoryService.getRecyclingHistoryUser(page, size);
    }

    @DeleteMapping("/deleteRecyclingHistory/{id}")
    public ResponseEntity<ApiResponse> deleteRecyclingHistory(@PathVariable Long id) {
        System.out.println("id: " + id);
        recyclingHistoryService.deleteRecyclingHistory(id);
        ApiResponse response = new ApiResponse("Recycling history deleted successfully", null);
        return ResponseEntity.ok(response);
    }
}
