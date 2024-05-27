package com.project.recycleit.controllers;

import com.project.recycleit.beans.ImageFeedback;
import com.project.recycleit.dtos.ApiResponse;
import com.project.recycleit.dtos.ImageFeedbackCreateDto;
import com.project.recycleit.services.ImageFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imageFeedback")
public class ImageFeedbackController {
    @Autowired
    private ImageFeedbackService imageFeedbackService;

    @PostMapping("/addImageFeedback")
    public ResponseEntity<ApiResponse> addImageFeedback(@RequestBody ImageFeedbackCreateDto imageFeedbackCreateDto) {
        imageFeedbackService.addImageFeedback(imageFeedbackCreateDto);
        ApiResponse response = new ApiResponse("Image feedback added successfully", null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getImageFeedback")
    public ResponseEntity<List<ImageFeedback>> getImageFeedback() {
        return ResponseEntity.ok(imageFeedbackService.getImageFeedback());
    }
}
