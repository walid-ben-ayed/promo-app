package com.promo.api.mapper;

import com.promo.api.dto.RegisterRequest;
import com.promo.domain.model.User;
import com.promo.domain.model.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    @Mapping(target = "role", expression = "java(mapRole(request.getRole()))")
    User toDomain(RegisterRequest request);
    
    default UserRole mapRole(String role) {
        return UserRole.valueOf(role.toUpperCase());
    }
}
