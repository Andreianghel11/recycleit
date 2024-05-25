package com.project.recycleit.repositories;

import com.project.recycleit.beans.WasteItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WasteItemRepository extends JpaRepository<WasteItem, Long> {
    Optional<WasteItem> findByName(String name);
}
