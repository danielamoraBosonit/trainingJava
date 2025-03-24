package com.realnaut.content.application;

import com.realnaut.content.domain.entity.User;


public interface GetUserUseCase {

    User getById(Long id);

}
