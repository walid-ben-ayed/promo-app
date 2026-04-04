package com.promo.infrastructure.mapper;

import com.promo.domain.model.Promotion;
import com.promo.infrastructure.entity.PromotionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
    Promotion toDomain(PromotionEntity entity);
    PromotionEntity toEntity(Promotion domain);
}
