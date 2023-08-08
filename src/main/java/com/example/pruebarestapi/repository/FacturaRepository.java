package com.example.pruebarestapi.repository;

import com.example.pruebarestapi.model.FacturaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FacturaRepository extends CrudRepository<FacturaModel, UUID> {
}
