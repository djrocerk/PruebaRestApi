package com.example.pruebarestapi.swagger.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PersonBaseSchema implements Serializable {

    @Serial
    private static final long serialVersionUID = 200L;

    @NotNull
    @JsonProperty("nombre")
    private String name;

    @NotNull
    @JsonProperty("apellido")
    private String lastName;

    @NotNull
    @JsonProperty("telefono")
    private Long phone;

    @JsonProperty("edad")
    private Long age;

    @JsonProperty("direccion")
    private String street;
}
