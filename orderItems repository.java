package com.oop.oop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    // Find all OrderItems by Order ID
    List<OrderItem> findByOrderOrderId(int orderId);

    // Find an OrderItem by its ID
    Optional<OrderItem> findById(int orderItemId);

    // Find all OrderItems by MenuItem ID
    List<OrderItem> findByMenuItemMenuItemId(int menuItemId);

    // Custom query to find all OrderItems for a specific order, optionally with sorting by MenuItem
    List<OrderItem> findByOrderOrderIdOrderByMenuItemMenuItemId(int orderId);
}
