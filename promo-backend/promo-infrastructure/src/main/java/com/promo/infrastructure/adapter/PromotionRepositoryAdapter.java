package com.promo.infrastructure.adapter;

import com.promo.domain.model.Promotion;
import com.promo.domain.port.PromotionRepository;
import com.promo.infrastructure.entity.PromotionEntity;
import com.promo.infrastructure.mapper.PromotionMapper;
import com.promo.infrastructure.repository.JpaPromotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PromotionRepositoryAdapter implements PromotionRepository {
    private final JpaPromotionRepository jpaRepository;
    private final PromotionMapper mapper;

    @Override
    public Promotion save(Promotion promotion) {
        PromotionEntity entity = mapper.toEntity(promotion);
        return mapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Promotion> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Promotion> findAll() {
        return jpaRepository.findAll().stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public List<Promotion> findByCategory(String category) {
        return jpaRepository.findByCategory(category).stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public List<Promotion> findActivePromotions() {
        return jpaRepository.findActivePromotions(LocalDateTime.now()).stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
