package com.promo.api.dto;

import jakarta.validation.constraints.*;
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
public class PromotionRequest {
    @NotBlank(message = "Title is required")
    private String title;
    
    private String description;
    
    private String imageUrl;
    
    @NotNull(message = "Original price is required")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal originalPrice;
    
    @NotNull(message = "Discounted price is required")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal discountedPrice;
    
    @Min(0)
    @Max(100)
    private Integer discountPercentage;
    
    @NotBlank(message = "Category is required")
    private String category;
    
    @NotNull(message = "Start date is required")
    private LocalDateTime startDate;
    
    @NotNull(message = "End date is required")
    private LocalDateTime endDate;
    
    private String merchantName;
}
