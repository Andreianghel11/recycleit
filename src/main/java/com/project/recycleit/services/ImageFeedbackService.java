package com.project.recycleit.services;

import com.project.recycleit.beans.ImageFeedback;
import com.project.recycleit.beans.WasteItem;
import com.project.recycleit.dtos.ImageFeedbackCreateDto;
import com.project.recycleit.exceptionHandler.ItemNotFoundException;
import com.project.recycleit.repositories.ImageFeedbackRepository;
import com.project.recycleit.repositories.WasteItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageFeedbackService {
    @Autowired
    private ImageFeedbackRepository imageFeedbackRepository;

    @Autowired
    private WasteItemRepository wasteItemRepository;

    public void addImageFeedback(ImageFeedbackCreateDto imageFeedbackCreateDto) {
        Optional<WasteItem> wasteItem = wasteItemRepository.findByName(imageFeedbackCreateDto.getWasteItemName());

        if (!wasteItem.isPresent()) {
            throw new ItemNotFoundException("Waste item not found");
        } else {
            ImageFeedback imageFeedback = new ImageFeedback(wasteItem.get(), imageFeedbackCreateDto.getImage());
            imageFeedbackRepository.save(imageFeedback);
        }
    }

    public List<ImageFeedback> getImageFeedback() {
        return imageFeedbackRepository.findAll();
    }

}
