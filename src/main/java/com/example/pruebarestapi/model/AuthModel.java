package com.example.pruebarestapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="auth")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthModel extends BaseEntityAudit {
    @Column(name = "USER")
    private String user;

    @Column(name = "PASSWORD")
    private String pass;
}
