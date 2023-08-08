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
public class AuthRestRegisterDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 11L;

    @NonNull
    @JsonProperty("autenticacion")
    private AuthRestDTO auth;

    @JsonProperty("persona")
    private PersonRestDto person;
}
