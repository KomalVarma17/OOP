package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CafeService cafeService;

    // Show all orders
    @GetMapping
    public String showOrderList(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order_list"; // View template to display the list of orders
    }

    // Show order details
    @GetMapping("/{id}")
    public String showOrderDetails(@PathVariable int id, Model model) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            model.addAttribute("order", order);
            return "order_details"; // View template to display order details
        }
        return "redirect:/orders"; // Redirect to the list if the order is not found
    }

    // Show the form to create a new order
    @GetMapping("/new")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("cafes", cafeService.getAllCafes()); // Add cafe options for selection
        return "order_form"; // View template for creating a new order
    }

    // Handle form submission to create a new order
    @PostMapping
    public String saveOrder(@ModelAttribute("order") Order order, @RequestParam("cafeId") int cafeId) {
        Cafe cafe = cafeService.getCafeById(cafeId);
        if (cafe != null) {
            order.setCafe(cafe);
            orderService.saveOrder(order);
            return "redirect:/orders"; // Redirect to the list after saving
        }
        return "redirect:/orders/new"; // Redirect back to the form if the cafe is invalid
    }

    // Delete an order
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return "redirect:/orders"; // Redirect to the list after deletion
    }

    // Update order payment status (for demonstration purposes)
    @PostMapping("/{id}/update-payment-status")
    public String updatePaymentStatus(@PathVariable int id, @RequestParam("paymentStatus") String paymentStatus) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            order.setPaymentStatus(paymentStatus);
            orderService.saveOrder(order);
        }
        return "redirect:/orders/" + id; // Redirect back to the order details
    }
}
