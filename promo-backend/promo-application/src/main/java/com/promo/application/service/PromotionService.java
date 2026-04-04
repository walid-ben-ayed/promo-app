package com.promo.application.service;

import com.promo.domain.model.Promotion;
import com.promo.domain.port.PromotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PromotionService {
    private final PromotionRepository promotionRepository;

    public Promotion createPromotion(Promotion promotion) {
        promotion.setCreatedAt(LocalDateTime.now());
        promotion.setActive(true);
        return promotionRepository.save(promotion);
    }

    public Promotion updatePromotion(Long id, Promotion promotion) {
        Promotion existing = promotionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Promotion not found"));
        
        promotion.setId(id);
        promotion.setCreatedAt(existing.getCreatedAt());
        promotion.setUpdatedAt(LocalDateTime.now());
        return promotionRepository.save(promotion);
    }

    @Transactional(readOnly = true)
    public Promotion getPromotionById(Long id) {
        return promotionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Promotion not found"));
    }

    @Transactional(readOnly = true)
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Promotion> getActivePromotions() {
        return promotionRepository.findActivePromotions();
    }

    @Transactional(readOnly = true)
    public List<Promotion> getPromotionsByCategory(String category) {
        return promotionRepository.findByCategory(category);
    }

    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }
}
