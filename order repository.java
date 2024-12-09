package com.oop.oop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Find all orders associated with a specific cafe
    List<Order> findByCafe(Cafe cafe);

    // Find all orders by payment status
    List<Order> findByPaymentStatus(String paymentStatus);

    // Find all orders for a specific customer name (if applicable)
    List<Order> findByCustomerName(String customerName);
}
