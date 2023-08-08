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
public class AuthRegisterOkSchema implements Serializable {

    @Serial
    private static final long serialVersionUID = 120L;

    @NotNull
    @JsonProperty("autenticacion")
    private AuthBaseSchema auth;

    @NotNull
    @JsonProperty("persona")
    private PersonBaseSchema person;
}
