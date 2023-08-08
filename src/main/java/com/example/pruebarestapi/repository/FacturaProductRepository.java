package com.example.pruebarestapi.repository;

import com.example.pruebarestapi.model.FacturaProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FacturaProductRepository extends JpaRepository<FacturaProductModel, UUID> {
}
