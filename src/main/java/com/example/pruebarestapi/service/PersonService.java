package com.example.pruebarestapi.service;

import com.example.pruebarestapi.dto.AuthRestRegisterDTO;
import com.example.pruebarestapi.dto.PersonRestDto;
import com.example.pruebarestapi.model.AuthModel;
import com.example.pruebarestapi.model.PersonModel;

import java.util.UUID;

public interface PersonService {
    AuthRestRegisterDTO created(PersonRestDto personDto, AuthModel authModel);
    Iterable<PersonModel> readAll();
    PersonRestDto readById(UUID id);
    PersonRestDto updated(UUID id, PersonRestDto personDto);
    void deleted(UUID id);
}
