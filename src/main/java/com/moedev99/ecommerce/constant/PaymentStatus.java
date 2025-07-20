package com.moedev99.ecommerce.constant;

public enum PaymentStatus {
    PENDING,      // Payment created but not yet confirmed
    PROCESSING,   // Payment is being processed (e.g., awaiting confirmation)
    COMPLETED,    // Payment successfully completed
    FAILED,       // Payment failed or was declined
    CANCELED,     // Payment was canceled before completion
    REFUNDED,     // Payment was refunded fully or partially
    CHARGEBACK    // Chargeback initiated by customer/bank
}
