package com.realnaut.content.infrastructure.repository.impl;

import com.realnaut.content.application.mapper.UserMapper;
import com.realnaut.content.domain.entity.User;
import com.realnaut.content.domain.repository.GetUserRepository;
import com.realnaut.content.infrastructure.repository.jpa.UserRepositoryJpa;
import com.realnaut.content.infrastructure.repository.jpa.entity.UserJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class GetUserRepositoryImpl implements GetUserRepository {

    private final UserRepositoryJpa repoJpa;

    private final UserMapper mapper;

    @Override
    public User getById(Long id) {

        UserJpa userJpa = repoJpa.getReferenceById(id);

        return mapper.jpaToDomain(userJpa);
    }

    @Override
    public User getByUserName(String userName) {
        UserJpa userJpa = repoJpa.findByUserName(userName);

        return mapper.jpaToDomain(userJpa);
    }


}
