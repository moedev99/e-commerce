package com.moedev99.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "CART_ITEM")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate(){
        createdAt = LocalDateTime.now();
    }

}
