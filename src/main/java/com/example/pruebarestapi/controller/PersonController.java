package com.example.pruebarestapi.controller;

import com.example.pruebarestapi.dto.FacturaDto;
import com.example.pruebarestapi.dto.PersonRestDto;
import com.example.pruebarestapi.dto.ProductDto;
import com.example.pruebarestapi.model.PersonModel;
import com.example.pruebarestapi.service.PersonService;
import com.example.pruebarestapi.swagger.schema.AuthRegisterOkSchema;
import com.example.pruebarestapi.swagger.schema.MessageResponseSchema;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name="Personas", description = "Esta es el api que realizar el crud")
@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    }
            )
    })
    @GetMapping
    public Iterable<PersonModel> readAll(){
        return this.personService.readAll();
    }

    @GetMapping("{id}")
    public PersonRestDto readById(@PathVariable(required = true) UUID id){
        return this.personService.readById(id);
    }

    @PutMapping("{id}")
    public PersonRestDto update(@PathVariable(required = true) UUID id, @RequestBody PersonRestDto personDto){
        return this.personService.updated(id, personDto);
    }

    @DeleteMapping("{id}")
    public void deleted(@PathVariable(required = true) UUID id){
        this.personService.deleted(id);
    }
}
