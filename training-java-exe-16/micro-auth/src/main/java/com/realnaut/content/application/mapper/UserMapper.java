package com.realnaut.content.application.mapper;

import com.realnaut.content.domain.entity.User;
import com.realnaut.content.infrastructure.repository.jpa.entity.UserJpa;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User jpaToDomain(UserJpa userJpa);

    UserJpa domainToJpa(User user);

}
