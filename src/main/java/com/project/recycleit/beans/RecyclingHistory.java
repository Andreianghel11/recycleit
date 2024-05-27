package com.project.recycleit.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name="recycling_history")
public class RecyclingHistory {
    @Id
    @GeneratedValue
    @Column(name="recycling_history_id")
    private Long recyclingHistoryId;

    @JoinColumn(name="user_id")
    @ManyToOne
    private User user;

    @JoinColumn(name="item_id")
    @ManyToOne
    private WasteItem wasteItem;

    @Column(name="quantity")
    private int quantity;

    @Column(name="timestamp")
    private LocalDateTime timestamp;

    @Column(name="image")
    private String image;

    public RecyclingHistory() {
    }

    public RecyclingHistory(User user, WasteItem wasteItem, int quantity, LocalDateTime timestamp, String image) {
        this.user = user;
        this.wasteItem = wasteItem;
        this.quantity = quantity;
        this.timestamp = timestamp;
        this.image = image;
    }

    public RecyclingHistory(int quantity, String image, LocalDateTime timestamp){
        this.quantity = quantity;
        this.image = image;
        this.timestamp = timestamp;
    }

    public Long getRecyclingHistoryId() {
        return recyclingHistoryId;
    }

    public void setRecyclingHistoryId(Long recyclingHistoryId) {
        this.recyclingHistoryId = recyclingHistoryId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WasteItem getWasteItem() {
        return wasteItem;
    }

    public void setWasteItem(WasteItem wasteItem) {
        this.wasteItem = wasteItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
