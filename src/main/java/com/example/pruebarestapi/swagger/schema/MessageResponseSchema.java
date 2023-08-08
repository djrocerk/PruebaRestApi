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
public class MessageResponseSchema implements Serializable {

    @Serial
    private static final long serialVersionUID = 100L;

    @NotNull
    @JsonProperty("mensaje")
    private String message;
}
