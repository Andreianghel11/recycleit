package com.project.recycleit.mappers;

import com.project.recycleit.beans.User;
import com.project.recycleit.dtos.UserDto;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto(user);
    }

    public static User toUser(UserDto userDto) {
        return new User(userDto.getUserId(), userDto.getEmail(), userDto.getPasswordHash(), userDto.getFirstname(),
                userDto.getLastname(), userDto.getCreatedAt(), userDto.getRole(), userDto.getPicture(),
                userDto.getItemsScanned(), userDto.getTitle(), userDto.getPlasticItemsScanned(),
                userDto.getMetalItemsScanned(), userDto.getGlassItemsScanned(), userDto.getCardboardItemsScanned(),
                userDto.getBiologicalItemsScanned(), userDto.getBatteryItemsScanned(), userDto.getPaperItemsScanned(),
                userDto.getShoesItemsScanned(), userDto.getClothesItemsScanned(), userDto.getTrashItemsScanned());
    }
}
