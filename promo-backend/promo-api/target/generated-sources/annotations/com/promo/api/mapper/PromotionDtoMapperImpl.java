package com.promo.api.mapper;

import com.promo.api.dto.PromotionRequest;
import com.promo.api.dto.PromotionResponse;
import com.promo.domain.model.Promotion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-04T20:18:03+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class PromotionDtoMapperImpl implements PromotionDtoMapper {

    @Override
    public Promotion toDomain(PromotionRequest request) {
        if ( request == null ) {
            return null;
        }

        Promotion.PromotionBuilder promotion = Promotion.builder();

        promotion.title( request.getTitle() );
        promotion.description( request.getDescription() );
        promotion.imageUrl( request.getImageUrl() );
        promotion.originalPrice( request.getOriginalPrice() );
        promotion.discountedPrice( request.getDiscountedPrice() );
        promotion.discountPercentage( request.getDiscountPercentage() );
        promotion.category( request.getCategory() );
        promotion.startDate( request.getStartDate() );
        promotion.endDate( request.getEndDate() );
        promotion.merchantName( request.getMerchantName() );

        return promotion.build();
    }

    @Override
    public PromotionResponse toResponse(Promotion domain) {
        if ( domain == null ) {
            return null;
        }

        PromotionResponse.PromotionResponseBuilder promotionResponse = PromotionResponse.builder();

        promotionResponse.id( domain.getId() );
        promotionResponse.title( domain.getTitle() );
        promotionResponse.description( domain.getDescription() );
        promotionResponse.imageUrl( domain.getImageUrl() );
        promotionResponse.originalPrice( domain.getOriginalPrice() );
        promotionResponse.discountedPrice( domain.getDiscountedPrice() );
        promotionResponse.discountPercentage( domain.getDiscountPercentage() );
        promotionResponse.category( domain.getCategory() );
        promotionResponse.startDate( domain.getStartDate() );
        promotionResponse.endDate( domain.getEndDate() );
        promotionResponse.active( domain.getActive() );
        promotionResponse.merchantName( domain.getMerchantName() );
        promotionResponse.createdAt( domain.getCreatedAt() );

        return promotionResponse.build();
    }
}
