package com.promo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PromotionRequest {
    @NotBlank(message = "Titre est requis")
    private String title;
    
    private String description;
    private String imageUrl;
    
    @NotNull(message = "Prix original est requis")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal originalPrice;
    
    @NotNull(message = "Prix réduit est requis")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal discountedPrice;
    
    @Min(0) @Max(100)
    private Integer discountPercentage;
    
    @NotBlank(message = "Catégorie est requise")
    private String category;
    
    @NotNull(message = "Date de début est requise")
    private LocalDateTime startDate;
    
    @NotNull(message = "Date de fin est requise")
    private LocalDateTime endDate;
    
    private String merchantName;
}
