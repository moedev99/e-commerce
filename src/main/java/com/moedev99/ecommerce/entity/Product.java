package com.moedev99.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CATEGORY")
    private final String category;
    @Column(name = "NAME")
    private final String name;
    @Column(name = "URL")
    private final String url;
    @Column(name = "PRICE")
    private final double price;
    @Column(name = "DISCOUNT")
    private final double discount;
    @Column(name = "QUANTITY_IN_STOCK")
    private final int quantityInStock;

}
