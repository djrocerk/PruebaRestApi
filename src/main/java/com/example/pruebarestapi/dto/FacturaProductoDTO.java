package com.example.pruebarestapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class FacturaProductoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 412;

    @JsonProperty("producto_id")
    private UUID productId;

    @JsonProperty("cantidad")
    private int amount;
}
