package com.example.pruebarestapi.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class ResponseJsonDto implements Serializable {
    private HttpStatus httpStatus;
    private String message;
}
