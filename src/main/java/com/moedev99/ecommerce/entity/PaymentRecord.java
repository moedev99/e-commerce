package com.moedev99.ecommerce.entity;

import com.moedev99.ecommerce.constant.PaymentMethod;
import com.moedev99.ecommerce.constant.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "PAYMENT_RECORD")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ORDER_ID", unique = true)
    private Order order;

    @Column(name = "PAYMENT_STATUS")
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Column(name = "PAYMENT_METHOD")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "STRIPE_PAYMENT_ID", unique = true)
    private String stripePaymentId;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate(){
        createdAt = LocalDateTime.now();
    }

}
