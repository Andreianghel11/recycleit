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

    public UserDto(Long userId, String email, String passwordHash, Date createdAt, String firstname, String lastname, Role role) {
        this.userId = userId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.createdAt = createdAt;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }

    public UserDto(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.passwordHash = user.getPasswordHash();
        this.createdAt = user.getCreatedAt();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.role = user.getRole();
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
