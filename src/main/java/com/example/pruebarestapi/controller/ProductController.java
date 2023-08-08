package com.example.pruebarestapi.controller;

import com.example.pruebarestapi.dto.ProductDto;
import com.example.pruebarestapi.model.ProductsModel;
import com.example.pruebarestapi.service.ProductService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Tag(name="Productos", description = "Esta es el api que realizar el crud")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = ProductsModel.class)),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    }
            )
    })
    @GetMapping
    public Iterable<ProductsModel> readAll(){
        return this.productService.readAll();
    }

    @PostMapping
    public ProductDto created(@RequestBody ProductDto productDto) {
        return this.productService.created(productDto);
    }

    @GetMapping("{id}")
    public ProductDto readById(@PathVariable(required = true) UUID id){
        return this.productService.readById(id);
    }

    @PutMapping("{id}")
    public ProductDto update(@PathVariable(required = true) UUID id, @RequestBody ProductDto productDto){
        return this.productService.updated(id, productDto);
    }

    @DeleteMapping("{id}")
    public void deleted(@PathVariable(required = true) UUID id){
        this.productService.deleted(id);
    }
}
