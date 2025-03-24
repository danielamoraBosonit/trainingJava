package com.realnaut.content.domain.repository;

import com.realnaut.content.domain.entity.User;


public interface GetUserRepository {
    User getById(Long id);

    User getByUserName(String userName);
}
