package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    // Fetch all OrderItems
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    // Fetch OrderItems by Order ID
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {
        return orderItemRepository.findByOrderOrderId(orderId);
    }

    // Fetch OrderItem by OrderItem ID
    public Optional<OrderItem> getOrderItemById(int orderItemId) {
        return orderItemRepository.findById(orderItemId);
    }

    // Save a new OrderItem
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    // Update an existing OrderItem
    public OrderItem updateOrderItem(int orderItemId, OrderItem updatedOrderItem) {
        Optional<OrderItem> existingOrderItem = orderItemRepository.findById(orderItemId);
        if (existingOrderItem.isPresent()) {
            OrderItem orderItem = existingOrderItem.get();
            orderItem.setMenuItem(updatedOrderItem.getMenuItem());
            orderItem.setQuantity(updatedOrderItem.getQuantity());
            orderItem.setPrice(updatedOrderItem.getPrice());
            return orderItemRepository.save(orderItem);
        }
        return null; // Return null if not found
    }

    // Delete an OrderItem by its ID
    public void deleteOrderItem(int orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }

    // Fetch all OrderItems for a specific MenuItem ID
    public List<OrderItem> getOrderItemsByMenuItemId(int menuItemId) {
        return orderItemRepository.findByMenuItemMenuItemId(menuItemId);
    }

    // Fetch all OrderItems for a specific Order, ordered by MenuItem ID
    public List<OrderItem> getOrderItemsByOrderIdSorted(int orderId) {
        return orderItemRepository.findByOrderOrderIdOrderByMenuItemMenuItemId(orderId);
    }

    // Method to calculate the total price of all order items for a specific Order
    public double calculateTotalPrice(int orderId) {
        List<OrderItem> orderItems = getOrderItemsByOrderId(orderId);
        double totalPrice = 0.0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getPrice() * orderItem.getQuantity();
        }
        return totalPrice;
    }
}
