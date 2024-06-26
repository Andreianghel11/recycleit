package com.project.recycleit.beans;

import com.project.recycleit.services.WasteItemService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="recycling_facts")
public class RecyclingFact {
    @Id
    @GeneratedValue
    @Column(name="recycling_fact_id")
    private Long recyclingFactId;

    @JoinColumn(name="item_id")
    @ManyToOne
    private WasteItem wasteItem;

    @Column(name="fact")
    private String fact;

    public RecyclingFact() {
    }

    public RecyclingFact(WasteItem wasteItem, String fact) {
        this.wasteItem = wasteItem;
        this.fact = fact;
    }

    public Long getRecyclingFactId() {
        return recyclingFactId;
    }

    public void setRecyclingFactId(Long recyclingFactId) {
        this.recyclingFactId = recyclingFactId;
    }

    public WasteItem getWasteItem() {
        return wasteItem;
    }

    public void setWasteItem(WasteItem wasteItem) {
        this.wasteItem = wasteItem;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
