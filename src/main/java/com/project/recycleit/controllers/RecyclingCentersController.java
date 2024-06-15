package com.project.recycleit.controllers;

import com.project.recycleit.dtos.LocationDto;
import com.project.recycleit.services.RecyclingCentersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recyclingCenters")
public class RecyclingCentersController {
    @Autowired
    private RecyclingCentersService recyclingCentersService;

    @GetMapping("/getRecyclingCenters")
    public ResponseEntity<List<LocationDto>> getNearbyRecyclingCenters(@RequestParam double latitude, @RequestParam double longitude, @RequestParam int radius) {
        System.out.println("hello from controller");

        try {
            List<LocationDto> response = recyclingCentersService.getNearbyRecyclingCenters(latitude, longitude, radius);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(List.of());
        }
    }
}
