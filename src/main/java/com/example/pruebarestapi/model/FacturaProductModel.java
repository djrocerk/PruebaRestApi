package com.example.pruebarestapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "BILL_PRODUCTS")
public class FacturaProductModel extends BaseEntityAudit {

    @Column(name = "AMOUNT")
    private int amount;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductsModel product;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private FacturaModel bill;
}
