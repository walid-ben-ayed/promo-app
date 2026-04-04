package com.promo.infrastructure.mapper;

import com.promo.domain.model.User;
import com.promo.infrastructure.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-04T20:17:59+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toDomain(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( entity.getId() );
        user.email( entity.getEmail() );
        user.password( entity.getPassword() );
        user.firstName( entity.getFirstName() );
        user.lastName( entity.getLastName() );
        user.phoneNumber( entity.getPhoneNumber() );
        user.role( entity.getRole() );
        user.active( entity.getActive() );
        user.createdAt( entity.getCreatedAt() );
        user.updatedAt( entity.getUpdatedAt() );

        return user.build();
    }

    @Override
    public UserEntity toEntity(User domain) {
        if ( domain == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( domain.getId() );
        userEntity.email( domain.getEmail() );
        userEntity.password( domain.getPassword() );
        userEntity.firstName( domain.getFirstName() );
        userEntity.lastName( domain.getLastName() );
        userEntity.phoneNumber( domain.getPhoneNumber() );
        userEntity.role( domain.getRole() );
        userEntity.active( domain.getActive() );
        userEntity.createdAt( domain.getCreatedAt() );
        userEntity.updatedAt( domain.getUpdatedAt() );

        return userEntity.build();
    }
}
