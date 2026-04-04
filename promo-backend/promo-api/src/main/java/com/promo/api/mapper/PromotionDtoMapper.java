package com.promo.api.mapper;

import com.promo.api.dto.PromotionRequest;
import com.promo.api.dto.PromotionResponse;
import com.promo.domain.model.Promotion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PromotionDtoMapper {
    Promotion toDomain(PromotionRequest request);
    PromotionResponse toResponse(Promotion domain);
}
