package com.project.recycleit.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.recycleit.beans.Role;
import com.project.recycleit.beans.User;

import java.sql.Date;

public class UserDto {

    @JsonProperty
    private final Long userId;

    @JsonProperty
    private final String email;

    @JsonProperty
    private final String passwordHash;

    @JsonProperty
    private final Date createdAt;

    @JsonProperty
    private final String firstname;

    @JsonProperty
    private final String lastname;

    @JsonProperty
    private final Role role;

    @JsonProperty
    private final String picture;

    @JsonProperty
    private final Integer itemsScanned;

    @JsonProperty
    private final String title;

    @JsonProperty
    private final Integer plasticItemsScanned;

    @JsonProperty
    private final Integer metalItemsScanned;

    @JsonProperty
    private final Integer glassItemsScanned;

    @JsonProperty
    private final Integer cardboardItemsScanned;

    @JsonProperty
    private final Integer biologicalItemsScanned;

    @JsonProperty
    private final Integer batteryItemsScanned;

    @JsonProperty
    private final Integer paperItemsScanned;

    @JsonProperty
    private final Integer shoesItemsScanned;

    @JsonProperty
    private final Integer clothesItemsScanned;

    @JsonProperty
    private final Integer trashItemsScanned;

    public UserDto(Long userId, String email, String passwordHash, Date createdAt, String firstname,
                   String lastname, Role role, String picture, Integer itemsScanned, String title,
                   Integer plasticItemsScanned, Integer metalItemsScanned, Integer glassItemsScanned,
                   Integer cardboardItemsScanned, Integer biologicalItemsScanned, Integer batteryItemsScanned,
                   Integer paperItemsScanned, Integer shoesItemsScanned, Integer clothesItemsScanned,
                   Integer trashItemsScanned) {
        this.userId = userId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.createdAt = createdAt;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.picture = picture;
        this.itemsScanned = itemsScanned;
        this.title = title;
        this.plasticItemsScanned = plasticItemsScanned;
        this.metalItemsScanned = metalItemsScanned;
        this.glassItemsScanned = glassItemsScanned;
        this.cardboardItemsScanned = cardboardItemsScanned;
        this.biologicalItemsScanned = biologicalItemsScanned;
        this.batteryItemsScanned = batteryItemsScanned;
        this.paperItemsScanned = paperItemsScanned;
        this.shoesItemsScanned = shoesItemsScanned;
        this.clothesItemsScanned = clothesItemsScanned;
        this.trashItemsScanned = trashItemsScanned;
    }

    public UserDto(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.passwordHash = user.getPasswordHash();
        this.createdAt = user.getCreatedAt();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.role = user.getRole();
        this.picture = user.getPicture();
        this.itemsScanned = user.getItemsScanned();
        this.title = user.getTitle();
        this.plasticItemsScanned = user.getPlasticItemsScanned();
        this.metalItemsScanned = user.getMetalItemsScanned();
        this.glassItemsScanned = user.getGlassItemsScanned();
        this.cardboardItemsScanned = user.getCardboardItemsScanned();
        this.biologicalItemsScanned = user.getBiologicalItemsScanned();
        this.batteryItemsScanned = user.getBatteryItemsScanned();
        this.paperItemsScanned = user.getPaperItemsScanned();
        this.shoesItemsScanned = user.getShoesItemsScanned();
        this.clothesItemsScanned = user.getClothesItemsScanned();
        this.trashItemsScanned = user.getTrashItemsScanned();
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Role getRole() {
        return role;
    }

    public String getPicture() {
        return picture;
    }

    public Integer getItemsScanned() {
        return itemsScanned;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPlasticItemsScanned() {
        return plasticItemsScanned;
    }

    public Integer getMetalItemsScanned() {
        return metalItemsScanned;
    }

    public Integer getGlassItemsScanned() {
        return glassItemsScanned;
    }

    public Integer getCardboardItemsScanned() {
        return cardboardItemsScanned;
    }

    public Integer getBiologicalItemsScanned() {
        return biologicalItemsScanned;
    }

    public Integer getBatteryItemsScanned() {
        return batteryItemsScanned;
    }

    public Integer getPaperItemsScanned() {
        return paperItemsScanned;
    }

    public Integer getShoesItemsScanned() {
        return shoesItemsScanned;
    }

    public Integer getClothesItemsScanned() {
        return clothesItemsScanned;
    }

    public Integer getTrashItemsScanned() {
        return trashItemsScanned;
    }
}
