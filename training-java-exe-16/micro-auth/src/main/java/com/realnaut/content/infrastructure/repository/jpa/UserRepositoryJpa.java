package com.realnaut.content.infrastructure.repository.jpa;

import com.realnaut.content.infrastructure.repository.jpa.entity.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepositoryJpa extends JpaRepository<UserJpa, Long> {

    UserJpa findByUserName(String userName);
}
