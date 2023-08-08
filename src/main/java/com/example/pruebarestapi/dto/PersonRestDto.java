package com.example.pruebarestapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PersonRestDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 21L;

    @NotNull
    @JsonProperty("nombre")
    private String name;

    @JsonProperty("apellido")
    private String lastName;

    @JsonProperty("telefono")
    private Long phone;

    @JsonProperty("edad")
    private Long age;

    @JsonProperty("direccion")
    private String street;
}
