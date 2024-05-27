package com.project.recycleit.dtos;

public class ImageFeedbackCreateDto {
    private String wasteItemName;
    private String image;

    public ImageFeedbackCreateDto() {
    }

    public ImageFeedbackCreateDto(String wasteItemName, String image) {
        this.wasteItemName = wasteItemName;
        this.image = image;
    }

    public String getWasteItemName() {
        return wasteItemName;
    }

    public void setWasteItemName(String wasteItemName) {
        this.wasteItemName = wasteItemName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
