package com.project.recycleit.services;

import com.project.recycleit.beans.User;
import com.project.recycleit.dtos.UserDto;
import com.project.recycleit.exceptionHandler.ItemNotFoundException;
import com.project.recycleit.exceptionHandler.UserNotFoundException;
import com.project.recycleit.mappers.UserMapper;
import com.project.recycleit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void incrementScannedItemsForUser(String result) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> user = userRepository.findByEmail(username);

        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        } else {
            User userToUpdate = user.get();
            String waste = result.toLowerCase();
            switch (waste) {
                case "plastic":
                    userToUpdate.setPlasticItemsScanned(userToUpdate.getPlasticItemsScanned() + 1);
                    break;
                case "metal":
                    userToUpdate.setMetalItemsScanned(userToUpdate.getMetalItemsScanned() + 1);
                    break;
                case "glass":
                    userToUpdate.setGlassItemsScanned(userToUpdate.getGlassItemsScanned() + 1);
                    break;
                case "cardboard":
                    userToUpdate.setCardboardItemsScanned(userToUpdate.getCardboardItemsScanned() + 1);
                    break;
                case "biological":
                    userToUpdate.setBiologicalItemsScanned(userToUpdate.getBiologicalItemsScanned() + 1);
                    break;
                case "battery":
                    userToUpdate.setBiologicalItemsScanned(userToUpdate.getBatteryItemsScanned() + 1);
                    break;
                case "paper":
                    userToUpdate.setPaperItemsScanned(userToUpdate.getPaperItemsScanned() + 1);
                    break;
                case "shoes":
                    userToUpdate.setShoesItemsScanned(userToUpdate.getShoesItemsScanned() + 1);
                    break;
                case "clothes":
                    userToUpdate.setClothesItemsScanned(userToUpdate.getClothesItemsScanned() + 1);
                    break;
                case "trash":
                    userToUpdate.setTrashItemsScanned(userToUpdate.getTrashItemsScanned() + 1);
                    break;
                default:
                    break;
            }
            userToUpdate.setItemsScanned(userToUpdate.getItemsScanned() + 1);
            userRepository.save(userToUpdate);
        }
    }

    public UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        return UserMapper.toUserDto(user.get());
    }

    public UserDto updateUserPicture(Long userId, String picture) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setPicture(picture);
        userRepository.save(user);
        return new UserDto(user);
    }
}
