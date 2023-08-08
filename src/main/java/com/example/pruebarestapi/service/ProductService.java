package com.example.pruebarestapi.service;

import com.example.pruebarestapi.dto.ProductDto;
import com.example.pruebarestapi.model.ProductsModel;

import java.util.UUID;

public interface ProductService {
    ProductDto created(ProductDto productDto);
    Iterable<ProductsModel> readAll();
    ProductDto readById(UUID id);
    ProductDto updated(UUID id, ProductDto productDto);
    void deleted(UUID id);
}
