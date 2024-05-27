package com.project.recycleit.repositories;

import com.project.recycleit.beans.ImageFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageFeedbackRepository extends JpaRepository<ImageFeedback, Long> {
}
