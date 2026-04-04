package com.promo.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "promotions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    private String imageUrl;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal originalPrice;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal discountedPrice;
    
    private Integer discountPercentage;
    
    private String category;
    
    private LocalDateTime startDate;
    
    private LocalDateTime endDate;
    
    @Column(nullable = false)
    private Boolean active;
    
    private String merchantName;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}
