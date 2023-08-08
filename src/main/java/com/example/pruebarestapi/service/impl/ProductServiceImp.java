package com.example.pruebarestapi.service.impl;

import com.example.pruebarestapi.dto.ProductDto;
import com.example.pruebarestapi.model.ProductsModel;
import com.example.pruebarestapi.repository.ProductRepository;
import com.example.pruebarestapi.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImp implements ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    public ProductServiceImp(ModelMapper modelMapper, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto created(ProductDto productDto) {
        ProductsModel productsModel = modelMapper.map(productDto, ProductsModel.class);
        ProductsModel productsModelSaved = this.productRepository.save(productsModel);
        return modelMapper.map(productsModelSaved, ProductDto.class);
    }

    @Override
    public Iterable<ProductsModel> readAll() {
        return this.productRepository.findAll();
    }

    @Override
    public ProductDto readById(UUID id) {
        Optional<ProductsModel> productsModelOptional = this.productRepository.findById(id);
        ProductsModel productsModel= null;
        if(productsModelOptional.isPresent()){
            productsModel = productsModelOptional.get();
        }
        return modelMapper.map(productsModel, ProductDto.class);
    }

    @Override
    public ProductDto updated(UUID id, ProductDto productDto) {
        Optional<ProductsModel> productsModelOptional = this.productRepository.findById(id);
        ProductsModel productsModel = null;
        if(productsModelOptional.isPresent()){
            productsModel = productsModelOptional.get();
            productsModel.setName(productDto.getName());
            productsModel.setDescription(productDto.getDescription());
            productsModel.setPrice(productDto.getPrice());
            productsModel.setStock(productDto.getStock());
            productsModel.setUrlImg(productDto.getUrlImg());
            productsModel = productRepository.save(productsModel);
        }
        return modelMapper.map(productsModel, ProductDto.class);
    }

    @Override
    public void deleted(UUID id) {
        Optional<ProductsModel> productsModelOptional = this.productRepository.findById(id);
        productsModelOptional.ifPresent(this.productRepository::delete);
    }
}
