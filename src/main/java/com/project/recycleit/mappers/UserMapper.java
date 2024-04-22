package com.project.recycleit.mappers;

import com.project.recycleit.beans.User;
import com.project.recycleit.dtos.UserDto;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto(user.getUserId(), user.getEmail(), user.getPasswordHash(), user.getCreatedAt(), user.getFirstname(), user.getLastname(), user.getRole());
    }

    public static User toUser(UserDto userDto) {
        return new User(userDto.getUserId(), userDto.getEmail(), userDto.getPasswordHash(), userDto.getFirstname(), userDto.getLastname(), userDto.getCreatedAt(), userDto.getRole());
    }
}
