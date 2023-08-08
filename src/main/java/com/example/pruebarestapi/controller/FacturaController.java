package com.example.pruebarestapi.controller;

import com.example.pruebarestapi.dto.FacturaDto;
import com.example.pruebarestapi.dto.ProductDto;
import com.example.pruebarestapi.model.FacturaModel;
import com.example.pruebarestapi.service.FacturaService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name="Facturas", description = "Esta es el api que realizar el crud")
@RestController
@RequestMapping("/api/factura")
public class FacturaController {
    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = FacturaModel.class)),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    }
            )
    })
    @GetMapping
    public Iterable<FacturaModel> readAll(){
        return this.facturaService.readAll();
    }

    @PostMapping
    public FacturaDto created(@RequestBody FacturaDto facturaDto) {
        return this.facturaService.created(facturaDto);
    }

    @GetMapping("{id}")
    public FacturaDto readById(@PathVariable(required = true) UUID id){
        return this.facturaService.readById(id);
    }

    @PutMapping("{id}")
    public FacturaDto updated(@PathVariable(required = true) UUID id, @RequestBody FacturaDto facturaDto){
        return this.facturaService.updated(id, facturaDto);
    }

    @DeleteMapping("{id}")
    public void deleted(@PathVariable(required = true) UUID id){
        this.facturaService.deleted(id);
    }
}
