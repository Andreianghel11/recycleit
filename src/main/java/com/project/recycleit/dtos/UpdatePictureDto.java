package com.project.recycleit.dtos;

public class UpdatePictureDto {
    private Long userId;
    private String picture;

    public UpdatePictureDto() {
    }

    public UpdatePictureDto(Long userId, String picture) {
        this.userId = userId;
        this.picture = picture;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
