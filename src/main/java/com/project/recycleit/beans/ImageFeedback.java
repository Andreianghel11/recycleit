package com.project.recycleit.beans;

import jakarta.persistence.*;

@Entity
@Table(name="image_feedback")
public class ImageFeedback {
    @Id
    @GeneratedValue
    @Column(name="image_feedback_id")
    private Long imageFeedbackId;

    @JoinColumn(name="waste_item_id")
    @ManyToOne
    private WasteItem wasteItem;

    @Column(name="image")
    private String image;

    public ImageFeedback() {
    }

    public ImageFeedback(Long imageFeedbackId, WasteItem wasteItem, String image) {
        this.imageFeedbackId = imageFeedbackId;
        this.wasteItem = wasteItem;
        this.image = image;
    }

    public ImageFeedback(WasteItem wasteItem, String image) {
        this.wasteItem = wasteItem;
        this.image = image;
    }

    public Long getImageFeedbackId() {
        return imageFeedbackId;
    }

    public void setImageFeedbackId(Long imageFeedbackId) {
        this.imageFeedbackId = imageFeedbackId;
    }

    public WasteItem getWasteItem() {
        return wasteItem;
    }

    public void setWasteItem(WasteItem wasteItem) {
        this.wasteItem = wasteItem;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
