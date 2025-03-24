package com.training.content.application;

import com.training.content.domain.entity.User;


public interface GetUserUseCase {

    User getById(Long id);

}
