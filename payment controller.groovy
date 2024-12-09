package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")  // Base URL for payment-related endpoints
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Get all payments
    @GetMapping("/")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();  // Call the service method to get all payments
    }

    // Get payment by ID
    @GetMapping("/{paymentId}")
    public Payment getPaymentById(@PathVariable int paymentId) {
        return paymentService.getPaymentById(paymentId);  // Call service method to get a specific payment by ID
    }

    // Create or update a payment
    @PostMapping("/")
    public Payment savePayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);  // Call the service method to save the payment (either new or update)
    }

    // Delete a payment by ID
    @DeleteMapping("/{paymentId}")
    public void deletePayment(@PathVariable int paymentId) {
        paymentService.deletePayment(paymentId);  // Call service method to delete the payment by ID
    }

    // Update a payment's status
    @PutMapping("/{paymentId}")
    public Payment updatePaymentStatus(@PathVariable int paymentId, @RequestBody Payment payment) {
        return paymentService.updatePaymentStatus(paymentId, payment);  // Call service method to update payment status
    }
}
