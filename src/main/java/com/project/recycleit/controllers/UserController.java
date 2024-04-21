package com.project.recycleit.controllers;

import com.project.recycleit.beans.User;
import com.project.recycleit.dtos.UserDto;
import com.project.recycleit.repositories.UserRepository;
import com.project.recycleit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

}

