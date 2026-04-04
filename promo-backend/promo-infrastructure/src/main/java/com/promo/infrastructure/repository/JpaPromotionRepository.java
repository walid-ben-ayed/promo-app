package com.promo.infrastructure.repository;

import com.promo.infrastructure.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface JpaPromotionRepository extends JpaRepository<PromotionEntity, Long> {
    List<PromotionEntity> findByCategory(String category);
    
    @Query("SELECT p FROM PromotionEntity p WHERE p.active = true AND p.startDate <= :now AND p.endDate >= :now")
    List<PromotionEntity> findActivePromotions(LocalDateTime now);
}
