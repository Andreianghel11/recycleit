package com.project.recycleit.repositories;

import com.project.recycleit.beans.RecyclingHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecyclingHistoryRepository extends JpaRepository<RecyclingHistory, Long> {
    Optional<List<RecyclingHistory>> findAllByUserUserId(Long userId);

    Page<RecyclingHistory> findAllByUserUserIdOrderByTimestampDesc(Long userId, Pageable pageable);
}
