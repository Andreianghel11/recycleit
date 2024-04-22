package com.project.recycleit.repositories;

import com.project.recycleit.beans.UserAchievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAchievementRepository extends JpaRepository<UserAchievement, Long> {
    public Optional<List<UserAchievement>> findAllByUserUserId(Long userId);
}
