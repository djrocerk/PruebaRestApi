package com.example.pruebarestapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 31L;

    @NotBlank
    @Valid
    private String name;

    private String description;

    @Min(value = 0)
    @Valid
    private Long stock;

    @NotNull
    @Valid
    private Double price;

    private String urlImg;
}
