package com.project.recycleit.repositories;

import com.project.recycleit.beans.RecyclingFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingFactRepository extends JpaRepository<RecyclingFact, Long> {
}
