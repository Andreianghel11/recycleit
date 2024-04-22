package com.project.recycleit.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long userId;

    @Column(name="email")
    private String email;

    @Column(name="password_hash")
    private String passwordHash;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="created_at")
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy= "user")
    @JsonIgnore
    private List<RecyclingHistory> recyclingHistory;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy= "user")
    @JsonIgnore
    private List<UserAchievement> userAchievements;



    public User() {
    }

    public User(Long userId, String email, String passwordHash, String firstname, String lastname, Date createdAt, Role role) {
        this.userId = userId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdAt = createdAt;
        this.role = role;
    }

    public User(String email, String passwordHash, String firstname, String lastname, Date createdAt, Role role) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdAt = createdAt;
        this.role = role;
    }

    public User(String email, String passwordHash, String firstname, String lastname, Role role) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdAt = new Date(System.currentTimeMillis());
        this.role = role;
    }

    public User(String email, String passwordHash, String firstname, String lastname) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdAt = new Date(System.currentTimeMillis());
        this.role = Role.USER;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<RecyclingHistory> getRecyclingHistory() {
        return recyclingHistory;
    }

    public void setRecyclingHistory(List<RecyclingHistory> recyclingHistory) {
        this.recyclingHistory = recyclingHistory;
    }

    public List<UserAchievement> getUserAchievements() {
        return userAchievements;
    }

    public void setUserAchievements(List<UserAchievement> userAchievements) {
        this.userAchievements = userAchievements;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
