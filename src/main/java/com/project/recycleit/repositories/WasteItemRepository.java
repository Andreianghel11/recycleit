package com.project.recycleit.repositories;

import com.project.recycleit.beans.WasteItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteItemRepository extends JpaRepository<WasteItem, Long> {
}
