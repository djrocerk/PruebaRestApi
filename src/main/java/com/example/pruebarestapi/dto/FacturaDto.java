package com.example.pruebarestapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 41L;

    @NotNull
    @Valid
    private Double total;

    @JsonProperty("productos")
    private List<FacturaProductoDTO> products;
}
