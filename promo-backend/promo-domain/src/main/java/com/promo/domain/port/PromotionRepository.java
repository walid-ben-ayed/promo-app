package com.promo.domain.port;

import com.promo.domain.model.Promotion;

import java.util.List;
import java.util.Optional;

public interface PromotionRepository {
    Promotion save(Promotion promotion);
    Optional<Promotion> findById(Long id);
    List<Promotion> findAll();
    List<Promotion> findByCategory(String category);
    List<Promotion> findActivePromotions();
    void deleteById(Long id);
}
