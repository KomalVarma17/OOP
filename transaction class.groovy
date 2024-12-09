package com.oop.oop;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id") // Maps to the column 'transaction_id'
    private int transactionId;

    @Column(name = "amount", nullable = false) // Stores the amount of the transaction, cannot be null
    private double amount;

    @Column(name = "payment_method", nullable = false, length = 50) // Payment method (e.g., Credit Card, Cash)
    private String paymentMethod;

    @Column(name = "status", nullable = false, length = 20) // Status (e.g., Pending, Completed)
    private String status;

    @Column(name = "timestamp", nullable = false) // Stores the time the transaction was created
    private LocalDateTime timestamp;

    @ManyToOne // Many transactions can belong to one cafe
    @JoinColumn(name = "cafe_id", nullable = false) // Foreign key linking to Cafe
    private Cafe cafe;

    // Constructor
    public Transaction() {
    }

    public Transaction(double amount, String paymentMethod, String status, LocalDateTime timestamp, Cafe cafe) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.timestamp = timestamp;
        this.cafe = cafe;
    }

    // Getters and Setters

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }
}
