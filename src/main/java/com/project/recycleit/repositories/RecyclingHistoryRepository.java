package com.project.recycleit.repositories;

import com.project.recycleit.beans.RecyclingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingHistoryRepository extends JpaRepository<RecyclingHistory, Long> {
}
