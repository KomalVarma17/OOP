package com.oop.oop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    // Custom query to find payments by payment status
    List<Payment> findByPaymentStatus(String status);

    // Custom query to find payments by order ID
    List<Payment> findByOrder_OrderId(int orderId);

    // Custom query to find payments by transaction ID
    List<Payment> findByTransaction_TransactionId(int transactionId);

    // Method to find a payment by its ID
    Optional<Payment> findById(int paymentId);

    // Method to find a payment by its amount (if you want to search by amount)
    List<Payment> findByAmount(double amount);
}
