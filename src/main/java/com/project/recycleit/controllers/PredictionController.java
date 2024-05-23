package com.project.recycleit.controllers;

import com.project.recycleit.dtos.AchievementCreateDto;
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
    public ResponseEntity<Map<String, String>> predictImage(@RequestBody Map<String, String> payload) {
        String result = predictionService.predictImage(payload);

//        System.out.println("result in controller: " + result);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "text/plain");
//        return new ResponseEntity<>(result, headers, HttpStatus.OK);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, String> response = new HashMap<>();
        response.put("result", result);
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }
}
