package com.example.pruebarestapi.controller;

import com.example.pruebarestapi.dto.AuthRestDTO;
import com.example.pruebarestapi.dto.AuthRestRegisterDTO;
import com.example.pruebarestapi.dto.ResponseJsonDto;
import com.example.pruebarestapi.service.AuthService;
import com.example.pruebarestapi.swagger.schema.AuthLoginOkSchema;
import com.example.pruebarestapi.swagger.schema.AuthRegisterOkSchema;
import com.example.pruebarestapi.swagger.schema.MessageResponseSchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name="Autenticación", description = "Esta es el api que permite registrar y validar el ingreso")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = AuthRegisterOkSchema.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = MessageResponseSchema.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = MessageResponseSchema.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    }
            )
    })
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody AuthRestRegisterDTO authDto) {
        Map<String, Object> response = authService.register(authDto);
        return ResponseEntity.status((HttpStatusCode) response.get("status")).body(response.get("data"));
    }

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = MessageResponseSchema.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = MessageResponseSchema.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = MessageResponseSchema.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    }
            )
    })
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthRestDTO authDto) {
        Map<String, Object> response = authService.login(authDto);
        return ResponseEntity.status((HttpStatusCode) response.get("status")).body(response.get("data"));
    }
}
