package com.project.recycleit.services;

import com.project.recycleit.dtos.UserDto;
import com.project.recycleit.exceptionHandler.ItemNotFoundException;
import com.project.recycleit.mappers.UserMapper;
import com.project.recycleit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::toUserDto).toList();
    }

    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ItemNotFoundException("User not found");
        }
        userRepository.deleteById(userId);
    }
}
