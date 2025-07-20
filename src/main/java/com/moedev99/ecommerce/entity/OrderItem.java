package com.moedev99.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ORDER_ITEM")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "PRICE_AT_PURCHASE")
    private double priceAtPurchase;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate(){
        createdAt = LocalDateTime.now();
    }
}
