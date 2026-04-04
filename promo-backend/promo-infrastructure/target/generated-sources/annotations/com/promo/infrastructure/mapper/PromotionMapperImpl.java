package com.promo.infrastructure.mapper;

import com.promo.domain.model.Promotion;
import com.promo.infrastructure.entity.PromotionEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-04T20:17:59+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class PromotionMapperImpl implements PromotionMapper {

    @Override
    public Promotion toDomain(PromotionEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Promotion.PromotionBuilder promotion = Promotion.builder();

        promotion.id( entity.getId() );
        promotion.title( entity.getTitle() );
        promotion.description( entity.getDescription() );
        promotion.imageUrl( entity.getImageUrl() );
        promotion.originalPrice( entity.getOriginalPrice() );
        promotion.discountedPrice( entity.getDiscountedPrice() );
        promotion.discountPercentage( entity.getDiscountPercentage() );
        promotion.category( entity.getCategory() );
        promotion.startDate( entity.getStartDate() );
        promotion.endDate( entity.getEndDate() );
        promotion.active( entity.getActive() );
        promotion.merchantName( entity.getMerchantName() );
        promotion.createdAt( entity.getCreatedAt() );
        promotion.updatedAt( entity.getUpdatedAt() );

        return promotion.build();
    }

    @Override
    public PromotionEntity toEntity(Promotion domain) {
        if ( domain == null ) {
            return null;
        }

        PromotionEntity.PromotionEntityBuilder promotionEntity = PromotionEntity.builder();

        promotionEntity.id( domain.getId() );
        promotionEntity.title( domain.getTitle() );
        promotionEntity.description( domain.getDescription() );
        promotionEntity.imageUrl( domain.getImageUrl() );
        promotionEntity.originalPrice( domain.getOriginalPrice() );
        promotionEntity.discountedPrice( domain.getDiscountedPrice() );
        promotionEntity.discountPercentage( domain.getDiscountPercentage() );
        promotionEntity.category( domain.getCategory() );
        promotionEntity.startDate( domain.getStartDate() );
        promotionEntity.endDate( domain.getEndDate() );
        promotionEntity.active( domain.getActive() );
        promotionEntity.merchantName( domain.getMerchantName() );
        promotionEntity.createdAt( domain.getCreatedAt() );
        promotionEntity.updatedAt( domain.getUpdatedAt() );

        return promotionEntity.build();
    }
}
