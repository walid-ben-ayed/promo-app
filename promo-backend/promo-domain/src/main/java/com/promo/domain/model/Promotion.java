package com.promo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private BigDecimal originalPrice;
    private BigDecimal discountedPrice;
    private Integer discountPercentage;
    private String category;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean active;
    private String merchantName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
