package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MenuItemService menuItemService;

    // Display list of all Order Items
    @GetMapping
    public String listOrderItems(Model model) {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        model.addAttribute("orderItems", orderItems);
        return "order_item_list"; // Thymeleaf template for listing order items
    }

    // Display details of a single Order Item
    @GetMapping("/{id}")
    public String viewOrderItem(@PathVariable("id") int id, Model model) {
        OrderItem orderItem = orderItemService.getOrderItemById(id);
        if (orderItem != null) {
            model.addAttribute("orderItem", orderItem);
            return "order_item_details"; // Thymeleaf template for displaying order item details
        }
        return "redirect:/order-items"; // Redirect if order item not found
    }

    // Display form to create a new Order Item
    @GetMapping("/new")
    public String createOrderItemForm(Model model) {
        List<Order> orders = orderService.getAllOrders();
        List<MenuItem> menuItems = menuItemService.getAllMenuItems();

        model.addAttribute("orders", orders);
        model.addAttribute("menuItems", menuItems);
        model.addAttribute("orderItem", new OrderItem()); // New OrderItem to be filled
        return "order_item_form"; // Thymeleaf template for the form to create order item
    }

    // Process creation of a new Order Item
    @PostMapping("/new")
    public String createOrderItem(@ModelAttribute OrderItem orderItem) {
        orderItemService.saveOrderItem(orderItem);
        return "redirect:/order-items"; // Redirect to the order items list
    }

    // Display form to edit an existing Order Item
    @GetMapping("/edit/{id}")
    public String editOrderItemForm(@PathVariable("id") int id, Model model) {
        OrderItem orderItem = orderItemService.getOrderItemById(id);
        if (orderItem != null) {
            List<Order> orders = orderService.getAllOrders();
            List<MenuItem> menuItems = menuItemService.getAllMenuItems();

            model.addAttribute("orders", orders);
            model.addAttribute("menuItems", menuItems);
            model.addAttribute("orderItem", orderItem); // Existing OrderItem to be edited
            return "order_item_form"; // Thymeleaf template for editing order item
        }
        return "redirect:/order-items"; // Redirect if order item not found
    }

    // Process update of an existing Order Item
    @PostMapping("/edit/{id}")
    public String updateOrderItem(@PathVariable("id") int id, @ModelAttribute OrderItem orderItem) {
        orderItem.setOrderItemId(id);
        orderItemService.saveOrderItem(orderItem);
        return "redirect:/order-items"; // Redirect to the order items list after saving
    }

    // Delete an Order Item by ID
    @GetMapping("/delete/{id}")
    public String deleteOrderItem(@PathVariable("id") int id) {
        orderItemService.deleteOrderItem(id);
        return "redirect:/order-items"; // Redirect to the order items list after deletion
    }
}
