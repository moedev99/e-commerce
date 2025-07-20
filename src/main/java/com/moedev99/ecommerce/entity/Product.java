package com.moedev99.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "NAME")
    private String name;
    @Column(name = "URL")
    private String url;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "DISCOUNT")
    private double discount;
    @Column(name = "QUANTITY_IN_STOCK")
    private int quantityInStock;

}
