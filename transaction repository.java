package com.oop.oop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    // Custom query to find transactions by status
    List<Transaction> findByStatus(String status);

    // Custom query to find transactions for a specific cafe
    List<Transaction> findByCafe(Cafe cafe);

    // Custom query to find transactions within a date range
    List<Transaction> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    // Custom query to find transactions by payment method
    List<Transaction> findByPaymentMethod(String paymentMethod);
}
