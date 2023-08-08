package com.example.pruebarestapi.repository;

import com.example.pruebarestapi.model.ProductsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<ProductsModel, UUID> {
}
