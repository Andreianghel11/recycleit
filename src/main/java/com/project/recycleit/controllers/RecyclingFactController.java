package com.project.recycleit.controllers;

import com.project.recycleit.beans.RecyclingFact;
import com.project.recycleit.dtos.RecyclingFactCreateDto;
import com.project.recycleit.services.RecyclingFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recyclingFacts")
public class RecyclingFactController {
    @Autowired
    RecyclingFactService recyclingFactService;

    @PostMapping("/addRecyclingFact")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addRecyclingFact(@RequestBody RecyclingFactCreateDto recyclingFactCreateDto){
        recyclingFactService.addRecyclingFact(recyclingFactCreateDto);
        return ResponseEntity.ok("Recycling Fact added successfully.");
    }

    @GetMapping("/getAllRecyclingFacts")
    public ResponseEntity<List<RecyclingFact>> getAllRecyclingFacts() {
        return ResponseEntity.ok(recyclingFactService.getAllRecyclingFacts());
    }

    @GetMapping("/getRandomRecyclingFactByName/{wasteItemName}")
    public ResponseEntity<RecyclingFact> getRandomRecyclingFactByName(@PathVariable String wasteItemName) {
        if (recyclingFactService.getRandomRecyclingFactByName(wasteItemName) == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(recyclingFactService.getRandomRecyclingFactByName(wasteItemName));
    }
}
