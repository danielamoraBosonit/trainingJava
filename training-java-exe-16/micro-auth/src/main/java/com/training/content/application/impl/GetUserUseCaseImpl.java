package com.training.content.application.impl;

import com.training.content.application.GetUserUseCase;
import com.training.content.domain.entity.User;
import com.training.content.domain.repository.GetUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.UUID;


@Slf4j
@AllArgsConstructor
@Qualifier("GetUserUseCaseImpl")
@Service
public class GetUserUseCaseImpl implements GetUserUseCase, RegisteredClientRepository {

    private final GetUserRepository repo;


    @Override
    public User getById(Long id){

        return repo.getById(id);
    }

    @Override
    public void save(RegisteredClient registeredClient) {
    }

    @Override
    public RegisteredClient findById(String id) {
        return null;
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {

        User user = repo.getByUserName(clientId);

        RegisteredClient rc = userToRegisteredClient(user, clientId);
        return rc;

    }


    private RegisteredClient userToRegisteredClient(User user, String clientId){

        return RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId(user != null ? user.getUserName(): clientId)
                .clientSecret(user != null ? user.getPassword() : null)
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .scope("message:read")
                .scope("message:write")
                .build();
    }
}
