package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CafeRepository cafeRepository;

    // Fetch all transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Fetch a transaction by ID
    public Transaction getTransactionById(int transactionId) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
        return transaction.orElse(null); // Return null if not found
    }

    // Fetch transactions by status
    public List<Transaction> getTransactionsByStatus(String status) {
        return transactionRepository.findByStatus(status);
    }

    // Fetch transactions for a specific cafe
    public List<Transaction> getTransactionsByCafe(int cafeId) {
        Optional<Cafe> cafe = cafeRepository.findById(cafeId);
        return cafe.map(transactionRepository::findByCafe).orElse(null); // Return null if cafe not found
    }

    // Fetch transactions within a date range
    public List<Transaction> getTransactionsByDateRange(LocalDateTime start, LocalDateTime end) {
        return transactionRepository.findByTimestampBetween(start, end);
    }

    // Fetch transactions by payment method
    public List<Transaction> getTransactionsByPaymentMethod(String paymentMethod) {
        return transactionRepository.findByPaymentMethod(paymentMethod);
    }

    // Save a new transaction
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Update an existing transaction
    public Transaction updateTransaction(int transactionId, Transaction updatedTransaction) {
        Optional<Transaction> existingTransaction = transactionRepository.findById(transactionId);
        if (existingTransaction.isPresent()) {
            Transaction transaction = existingTransaction.get();
            transaction.setAmount(updatedTransaction.getAmount());
            transaction.setTimestamp(updatedTransaction.getTimestamp());
            transaction.setStatus(updatedTransaction.getStatus());
            transaction.setPaymentMethod(updatedTransaction.getPaymentMethod());
            transaction.setCafe(updatedTransaction.getCafe());
            return transactionRepository.save(transaction);
        }
        return null; // Return null if transaction not found
    }

    // Delete a transaction
    public void deleteTransaction(int transactionId) {
        transactionRepository.deleteById(transactionId);
    }
}
