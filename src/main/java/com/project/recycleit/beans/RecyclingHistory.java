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
    @JsonIgnore
    private User user;

    @JoinColumn(name="item_id")
    @ManyToOne
    private WasteItem wasteItem;

    @Column(name="quantity")
    private int quantity;

    @Column(name="recycled_at")
    private Date timestamp;
}
