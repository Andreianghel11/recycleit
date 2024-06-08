package com.project.recycleit.controllers;

import com.project.recycleit.dtos.AchievementCreateDto;
import com.project.recycleit.dtos.WasteItemDto;
import com.project.recycleit.services.PredictionService;
import com.project.recycleit.services.RecyclingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/image")
public class PredictionController {
    @Autowired
    PredictionService predictionService;

    @PostMapping("/predict")
    public ResponseEntity<WasteItemDto> predictImage(@RequestBody Map<String, String> payload) {
        WasteItemDto wasteItemDto = predictionService.predictImage(payload);
        System.out.println(wasteItemDto);
        if (wasteItemDto == null) {
            return ResponseEntity.internalServerError().build();
        } else {
            return ResponseEntity.ok(wasteItemDto);
        }
    }
}
