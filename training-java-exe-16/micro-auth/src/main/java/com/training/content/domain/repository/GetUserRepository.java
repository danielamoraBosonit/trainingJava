package com.training.content.domain.repository;

import com.training.content.domain.entity.User;


public interface GetUserRepository {
    User getById(Long id);

    User getByUserName(String userName);
}
