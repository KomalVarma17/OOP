package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CafeRepository cafeRepository;

    // Fetch all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Fetch an order by its ID
    public Order getOrderById(int orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order.orElse(null); // Return null if order is not found
    }

    // Fetch orders for a specific cafe
    public List<Order> getOrdersByCafe(int cafeId) {
        Optional<Cafe> cafe = cafeRepository.findById(cafeId);
        return cafe.map(orderRepository::findByCafe).orElse(null); // Return null if cafe is not found
    }

    // Fetch orders by payment status
    public List<Order> getOrdersByPaymentStatus(String paymentStatus) {
        return orderRepository.findByPaymentStatus(paymentStatus);
    }

    // Fetch orders by customer name
    public List<Order> getOrdersByCustomerName(String customerName) {
        return orderRepository.findByCustomerName(customerName);
    }

    // Save or update an order
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Delete an order by its ID
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }
}
