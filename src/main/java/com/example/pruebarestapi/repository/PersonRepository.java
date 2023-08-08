package com.example.pruebarestapi.repository;

import com.example.pruebarestapi.model.PersonModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends CrudRepository<PersonModel, UUID> {
}
