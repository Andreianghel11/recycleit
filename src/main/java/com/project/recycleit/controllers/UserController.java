package com.project.recycleit.controllers;

import com.project.recycleit.beans.User;
import com.project.recycleit.dtos.UpdatePictureDto;
import com.project.recycleit.dtos.UserDto;
import com.project.recycleit.repositories.UserRepository;
import com.project.recycleit.services.UserService;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully.");
    }

    @GetMapping("/getCurrentUser")
    public UserDto getCurrentUser() {
        return userService.getCurrentUser();
    }

    @PutMapping("/updatePicture")
    public ResponseEntity<UserDto> updateUserPicture(@RequestBody UpdatePictureDto request) {
        UserDto updatedUser = userService.updateUserPicture(request.getUserId(), request.getPicture());
        return ResponseEntity.ok(updatedUser);
    }

}

