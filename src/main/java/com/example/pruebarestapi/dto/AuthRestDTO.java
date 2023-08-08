package com.example.pruebarestapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AuthRestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 12L;

    @NonNull
    @JsonProperty("usuario")
    private String user;

    @NonNull
    @JsonProperty("contrasena")
    private String pass;
}
