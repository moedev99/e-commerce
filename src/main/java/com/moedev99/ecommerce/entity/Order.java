package com.moedev99.ecommerce.entity;

import com.moedev99.ecommerce.constant.OrderStatus;
import com.moedev99.ecommerce.constant.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
//because order is a reserved keyword in postgresql we need to change it
@Table(name = "ORDERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column(name = "PAYMENT_METHOD")
    private PaymentMethod paymentMethod;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @Column(name = "TOTAL_AMOUNT")
    private double totalAmount;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orders = new ArrayList<>();

    @PrePersist
    public void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    @PreUpdate
    public void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
