package com.example.pruebarestapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "BILLS")
public class FacturaModel extends BaseEntityAudit {

    @Column(name = "TOTAL")
    private Double total;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PersonModel person;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FacturaProductModel> billProduct;
}
