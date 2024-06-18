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

    @Column(name="picture")
    private String picture;

    @Column(name="items_scanned")
    private Integer itemsScanned;

    @Column(name="plastic_items_scanned")
    private Integer plasticItemsScanned;

    @Column(name="metal_items_scanned")
    private Integer metalItemsScanned;

    @Column(name="glass_items_scanned")
    private Integer glassItemsScanned;

    @Column(name="cardboard_items_scanned")
    private Integer cardboardItemsScanned;

    @Column(name="biological_items_scanned")
    private Integer biologicalItemsScanned;

    @Column(name="battery_items_scanned")
    private Integer batteryItemsScanned;

    @Column(name="paper_items_scanned")
    private Integer paperItemsScanned;

    @Column(name="shoes_items_scanned")
    private Integer shoesItemsScanned;

    @Column(name="clothes_items_scanned")
    private Integer clothesItemsScanned;

    @Column(name="trash_items_scanned")
    private Integer trashItemsScanned;

    @Column(name="title")
    private String title;

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

    public User(Long userId, String email, String passwordHash, String firstname, String lastname,
                Date createdAt, Role role, String picture, Integer itemsScanned, String title,
                Integer plasticItemsScanned, Integer metalItemsScanned, Integer glassItemsScanned,
                Integer cardboardItemsScanned, Integer biologicalItemsScanned, Integer batteryItemsScanned,
                Integer paperItemsScanned, Integer shoesItemsScanned, Integer clothesItemsScanned,
                Integer trashItemsScanned) {
        this.userId = userId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdAt = createdAt;
        this.role = role;
        this.picture = picture;
        this.itemsScanned = itemsScanned;
        this.title = title;
        this.plasticItemsScanned = plasticItemsScanned;
        this.metalItemsScanned = metalItemsScanned;
        this.glassItemsScanned = glassItemsScanned;
        this.cardboardItemsScanned = cardboardItemsScanned;
        this.biologicalItemsScanned = biologicalItemsScanned;
        this.batteryItemsScanned = batteryItemsScanned;
        this.paperItemsScanned = paperItemsScanned;
        this.shoesItemsScanned = shoesItemsScanned;
        this.clothesItemsScanned = clothesItemsScanned;
        this.trashItemsScanned = trashItemsScanned;
    }

    public User(String email, String passwordHash, String firstname, String lastname, Date createdAt, Role role) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdAt = createdAt;
        this.role = role;
        this.picture = "";
        this.itemsScanned = 0;
        this.title = "";
    }

    public User(String email, String passwordHash, String firstname, String lastname, Role role) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdAt = new Date(System.currentTimeMillis());
        this.role = role;
        this.picture = "";
        this.itemsScanned = 0;
        this.title = "";
        this.plasticItemsScanned = 0;
        this.metalItemsScanned = 0;
        this.glassItemsScanned = 0;
        this.cardboardItemsScanned = 0;
        this.biologicalItemsScanned = 0;
        this.batteryItemsScanned = 0;
        this.paperItemsScanned = 0;
        this.shoesItemsScanned = 0;
        this.clothesItemsScanned = 0;
        this.trashItemsScanned = 0;
    }

    public User(String email, String passwordHash, String firstname, String lastname) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdAt = new Date(System.currentTimeMillis());
        this.role = Role.USER;
        this.picture = "";
        this.itemsScanned = 0;
        this.title = "";
        this.plasticItemsScanned = 0;
        this.metalItemsScanned = 0;
        this.glassItemsScanned = 0;
        this.cardboardItemsScanned = 0;
        this.biologicalItemsScanned = 0;
        this.batteryItemsScanned = 0;
        this.paperItemsScanned = 0;
        this.shoesItemsScanned = 0;
        this.clothesItemsScanned = 0;
        this.trashItemsScanned = 0;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getItemsScanned() {
        return itemsScanned;
    }

    public void setItemsScanned(Integer itemsScanned) {
        this.itemsScanned = itemsScanned;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPlasticItemsScanned() {
        return plasticItemsScanned;
    }

    public void setPlasticItemsScanned(Integer plasticItemsScanned) {
        this.plasticItemsScanned = plasticItemsScanned;
    }

    public Integer getMetalItemsScanned() {
        return metalItemsScanned;
    }

    public void setMetalItemsScanned(Integer metalItemsScanned) {
        this.metalItemsScanned = metalItemsScanned;
    }

    public Integer getGlassItemsScanned() {
        return glassItemsScanned;
    }

    public void setGlassItemsScanned(Integer glassItemsScanned) {
        this.glassItemsScanned = glassItemsScanned;
    }

    public Integer getCardboardItemsScanned() {
        return cardboardItemsScanned;
    }

    public void setCardboardItemsScanned(Integer cardboardItemsScanned) {
        this.cardboardItemsScanned = cardboardItemsScanned;
    }

    public Integer getBiologicalItemsScanned() {
        return biologicalItemsScanned;
    }

    public void setBiologicalItemsScanned(Integer biologicalItemsScanned) {
        this.biologicalItemsScanned = biologicalItemsScanned;
    }

    public Integer getBatteryItemsScanned() {
        return batteryItemsScanned;
    }

    public void setBatteryItemsScanned(Integer batteryItemsScanned) {
        this.batteryItemsScanned = batteryItemsScanned;
    }

    public Integer getPaperItemsScanned() {
        return paperItemsScanned;
    }

    public void setPaperItemsScanned(Integer paperItemsScanned) {
        this.paperItemsScanned = paperItemsScanned;
    }

    public Integer getShoesItemsScanned() {
        return shoesItemsScanned;
    }

    public void setShoesItemsScanned(Integer shoesItemsScanned) {
        this.shoesItemsScanned = shoesItemsScanned;
    }

    public Integer getClothesItemsScanned() {
        return clothesItemsScanned;
    }

    public void setClothesItemsScanned(Integer clothesItemsScanned) {
        this.clothesItemsScanned = clothesItemsScanned;
    }

    public Integer getTrashItemsScanned() {
        return trashItemsScanned;
    }

    public void setTrashItemsScanned(Integer trashItemsScanned) {
        this.trashItemsScanned = trashItemsScanned;
    }
}
