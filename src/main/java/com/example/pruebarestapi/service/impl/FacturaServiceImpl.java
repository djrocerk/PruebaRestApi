package com.example.pruebarestapi.service.impl;

import com.example.pruebarestapi.dto.FacturaDto;
import com.example.pruebarestapi.dto.FacturaProductoDTO;
import com.example.pruebarestapi.model.FacturaModel;
import com.example.pruebarestapi.model.FacturaProductModel;
import com.example.pruebarestapi.model.ProductsModel;
import com.example.pruebarestapi.repository.FacturaProductRepository;
import com.example.pruebarestapi.repository.FacturaRepository;
import com.example.pruebarestapi.repository.ProductRepository;
import com.example.pruebarestapi.service.FacturaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FacturaServiceImpl implements FacturaService {

    private final ModelMapper modelMapper;
    private final FacturaRepository facturaRepository;
    private final ProductRepository productRepository;

    public FacturaServiceImpl(ModelMapper modelMapper, FacturaRepository facturaRepository, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.facturaRepository = facturaRepository;
        this.productRepository = productRepository;
    }

    @Override
    public FacturaDto created(FacturaDto facturaDto) {
        FacturaModel facturaModel = modelMapper.map(facturaDto, FacturaModel.class);
        List<FacturaProductModel> facturaProductModel = new ArrayList<>();
        if(!facturaDto.getProducts().isEmpty()) {
            for (FacturaProductoDTO facturaProductoDTO : facturaDto.getProducts())
                facturaProductModel.add(buildProducts(facturaProductoDTO, facturaModel));
        }
        facturaModel.setBillProduct(facturaProductModel);
        facturaModel = facturaRepository.save(facturaModel);
        return modelMapper.map(facturaModel, FacturaDto.class);
    }

    @Override
    public Iterable<FacturaModel> readAll() {
        return this.facturaRepository.findAll();
    }

    @Override
    public FacturaDto readById(UUID id) {
        Optional<FacturaModel> facturaModelOptional = this.facturaRepository.findById(id);
        FacturaModel facturaModel= null;
        if(facturaModelOptional.isPresent()){
            facturaModel = facturaModelOptional.get();
        }
        return modelMapper.map(facturaModel, FacturaDto.class);
    }

    @Override
    public FacturaDto updated(UUID id, FacturaDto facturaDto) {
        Optional<FacturaModel> facturaModelOptional = this.facturaRepository.findById(id);
        FacturaModel facturaModel= null;
        if(facturaModelOptional.isPresent()){
            facturaModel = facturaModelOptional.get();
            facturaModel.setTotal(facturaDto.getTotal());
            facturaModel = facturaRepository.save(facturaModel);
        }
        return modelMapper.map(facturaModel, FacturaDto.class);
    }

    @Override
    public void deleted(UUID id) {
        Optional<FacturaModel> facturaModelOptional = this.facturaRepository.findById(id);
        facturaModelOptional.ifPresent(this.facturaRepository::delete);
    }

    private FacturaProductModel buildProducts(FacturaProductoDTO facturaProducto, FacturaModel facturaModel) {
        Optional<ProductsModel> productsModel = productRepository.findById(facturaProducto.getProductId());
        FacturaProductModel facturaProductModel = new FacturaProductModel();
        if (productsModel.isPresent()) {
            facturaProductModel.setAmount(facturaProducto.getAmount());
            facturaProductModel.setProduct(productsModel.get());
            facturaProductModel.setBill(facturaModel);
        }
        return facturaProductModel;
    }
}
