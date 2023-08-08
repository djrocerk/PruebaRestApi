package com.example.pruebarestapi.repository;

import com.example.pruebarestapi.model.AuthModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AuthRepository extends CrudRepository<AuthModel, UUID> {
    public AuthModel findByUser(String user);
    public AuthModel findByUserAndPass(String user, String pass);
}
