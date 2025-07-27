package com.moedev99.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private  String category;
    @Column(name = "NAME")
    private  String name;
    @Column(name = "URL")
    private  String url;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "DISCOUNT")
    private  double discount;
    @Column(name = "QUANTITY_IN_STOCK")
    private int quantityInStock;

//    customer constructor
public Product(String category, String name,String url, double price, double discount, int quantityInStock) {
    this.category = category;
    this.url = url;
    this.name = name;
    this.price = price;
    this.discount = discount;
    this.quantityInStock = quantityInStock;
}

}
