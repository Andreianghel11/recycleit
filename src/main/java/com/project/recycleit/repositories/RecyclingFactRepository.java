package com.project.recycleit.repositories;

import com.project.recycleit.beans.RecyclingFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecyclingFactRepository extends JpaRepository<RecyclingFact, Long> {
}
