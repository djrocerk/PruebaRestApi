package com.example.pruebarestapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRODUCTS")
public class ProductsModel extends BaseEntityAudit {
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STOCK")
    private Long stock;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "URL_IMG")
    private String urlImg;
}
