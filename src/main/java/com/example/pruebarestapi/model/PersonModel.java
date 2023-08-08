package com.example.pruebarestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PERSONS")
public class PersonModel extends BaseEntityAudit{
    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST NAME")
    private String lastName;

    @Column(name = "PHONE")
    private Long phone;

    @Column(name = "AGE")
    private Long age;

    @Column(name = "DIRECCION")
    private String direccion;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private AuthModel auth;
}
