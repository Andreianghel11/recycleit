package com.project.recycleit.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;

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

    @Column(name="recycled_at")
    private Date timestamp;

    @Column(name="image")
    private String image;

    public RecyclingHistory() {
    }

    public RecyclingHistory(User user, WasteItem wasteItem, int quantity, Date timestamp, String image) {
        this.user = user;
        this.wasteItem = wasteItem;
        this.quantity = quantity;
        this.timestamp = timestamp;
        this.image = image;
    }

    public RecyclingHistory(Long wasteItemId, int quantity) {
        timestamp = new Date(System.currentTimeMillis());
    }

    public RecyclingHistory(int quantity, String image){
        this.quantity = quantity;
        this.image = image;
        timestamp = new Date(System.currentTimeMillis());
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
