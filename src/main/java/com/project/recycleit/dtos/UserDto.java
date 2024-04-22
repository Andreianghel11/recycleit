package com.project.recycleit.dtos;


import com.project.recycleit.beans.Role;

import java.sql.Date;

public class UserDto {

    private final Long userId;

    private final String email;

    private final String passwordHash;

    private final Date createdAt;

    private final String firstname;

    private final String lastname;

    private final Role role;

    public UserDto(Long userId, String email, String passwordHash, Date createdAt, String firstname, String lastname, Role role) {
        this.userId = userId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.createdAt = createdAt;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
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
}
