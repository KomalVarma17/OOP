package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get a payment by ID
    public Payment getPaymentById(int paymentId) {
        Optional<Payment> payment = paymentRepository.findById(paymentId);
        return payment.orElse(null); // Return null if payment not found
    }

    // Get payments by payment status (e.g., "Completed", "Pending")
    public List<Payment> getPaymentsByStatus(String status) {
        return paymentRepository.findByPaymentStatus(status);
    }

    // Get payments associated with a specific order ID
    public List<Payment> getPaymentsByOrderId(int orderId) {
        return paymentRepository.findByOrder_OrderId(orderId);
    }

    // Get payments associated with a specific transaction ID
    public List<Payment> getPaymentsByTransactionId(int transactionId) {
        return paymentRepository.findByTransaction_TransactionId(transactionId);
    }

    // Create or update a payment
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);  // Saves a new payment or updates an existing one
    }

    // Delete a payment by ID
    public void deletePayment(int paymentId) {
        paymentRepository.deleteById(paymentId);  // Deletes the payment with the given ID
    }

    // Get payments by amount (useful for querying payments of specific amounts)
    public List<Payment> getPaymentsByAmount(double amount) {
        return paymentRepository.findByAmount(amount);
    }

    // Update payment status
    public Payment updatePaymentStatus(int paymentId, String status) {
        Optional<Payment> paymentOpt = paymentRepository.findById(paymentId);
        if (paymentOpt.isPresent()) {
            Payment payment = paymentOpt.get();
            payment.setPaymentStatus(status);
            return paymentRepository.save(payment);  // Save the updated payment
        }
        return null;  
    }

    // Process payment (a placeholder method for handling payment logic)
    public boolean processPayment(Payment payment) {
        payment.setPaymentStatus("Completed");
        paymentRepository.save(payment);  // Save payment after processing
        return true;
    }
}
