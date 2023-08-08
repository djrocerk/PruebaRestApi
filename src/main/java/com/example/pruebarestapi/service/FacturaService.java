package com.example.pruebarestapi.service;

import com.example.pruebarestapi.dto.FacturaDto;
import com.example.pruebarestapi.dto.ProductDto;
import com.example.pruebarestapi.model.FacturaModel;
import com.example.pruebarestapi.model.ProductsModel;

import java.util.UUID;

public interface FacturaService {
    FacturaDto created(FacturaDto facturaDto);
    Iterable<FacturaModel> readAll();
    FacturaDto readById(UUID id);
    FacturaDto updated(UUID id, FacturaDto facturaDto);
    void deleted(UUID id);
}
