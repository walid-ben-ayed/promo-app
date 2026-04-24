package com.promo.service;

import com.promo.dto.PromotionRequest;
import com.promo.dto.PromotionResponse;
import com.promo.entity.Promotion;
import com.promo.repository.PromotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PromotionService {
    
    private final PromotionRepository promotionRepository;
    
    @Transactional
    public PromotionResponse createPromotion(PromotionRequest request) {
        Promotion promotion = Promotion.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .imageUrl(request.getImageUrl())
                .originalPrice(request.getOriginalPrice())
                .discountedPrice(request.getDiscountedPrice())
                .discountPercentage(request.getDiscountPercentage())
                .category(request.getCategory())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .merchantName(request.getMerchantName())
                .active(true)
                .build();
        
        Promotion saved = promotionRepository.save(promotion);
        return toResponse(saved);
    }
    
    @Transactional
    public PromotionResponse updatePromotion(Long id, PromotionRequest request) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promotion non trouvée"));
        
        promotion.setTitle(request.getTitle());
        promotion.setDescription(request.getDescription());
        promotion.setImageUrl(request.getImageUrl());
        promotion.setOriginalPrice(request.getOriginalPrice());
        promotion.setDiscountedPrice(request.getDiscountedPrice());
        promotion.setDiscountPercentage(request.getDiscountPercentage());
        promotion.setCategory(request.getCategory());
        promotion.setStartDate(request.getStartDate());
        promotion.setEndDate(request.getEndDate());
        promotion.setMerchantName(request.getMerchantName());
        
        Promotion updated = promotionRepository.save(promotion);
        return toResponse(updated);
    }
    
    @Transactional(readOnly = true)
    public PromotionResponse getPromotionById(Long id) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promotion non trouvée"));
        return toResponse(promotion);
    }
    
    @Transactional(readOnly = true)
    public List<PromotionResponse> getAllPromotions() {
        return promotionRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public List<PromotionResponse> getActivePromotions() {
        return promotionRepository.findActivePromotions(LocalDateTime.now()).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public List<PromotionResponse> getPromotionsByCategory(String category) {
        return promotionRepository.findByCategory(category).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }
    
    private PromotionResponse toResponse(Promotion promotion) {
        return PromotionResponse.builder()
                .id(promotion.getId())
                .title(promotion.getTitle())
                .description(promotion.getDescription())
                .imageUrl(promotion.getImageUrl())
                .originalPrice(promotion.getOriginalPrice())
                .discountedPrice(promotion.getDiscountedPrice())
                .discountPercentage(promotion.getDiscountPercentage())
                .category(promotion.getCategory())
                .startDate(promotion.getStartDate())
                .endDate(promotion.getEndDate())
                .active(promotion.getActive())
                .merchantName(promotion.getMerchantName())
                .createdAt(promotion.getCreatedAt())
                .build();
    }
}
