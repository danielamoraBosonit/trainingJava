package com.training.content.application.mapper;

import com.training.content.domain.entity.User;
import com.training.content.infrastructure.repository.jpa.entity.UserJpa;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User jpaToDomain(UserJpa userJpa);

    UserJpa domainToJpa(User user);

}
