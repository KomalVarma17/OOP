package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public String showTransactionList(Model model) {
        // Fetch and display all transactions
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "transaction_list"; // View for listing all transactions
    }

    @GetMapping("/transaction/{id}")
    public String showTransactionDetails(@PathVariable int id, Model model) {
        // Fetch details of a specific transaction by ID
        Transaction transaction = transactionService.getTransactionById(id);
        if (transaction != null) {
            model.addAttribute("transaction", transaction);
            return "transaction_details"; // View for detailed transaction information
        }
        return "redirect:/transactions"; // Redirect to transaction list if not found
    }

    @GetMapping("/transaction/new")
    public String showNewTransactionForm(Model model) {
        // Show a form for creating a new transaction
        model.addAttribute("transaction", new Transaction());
        return "transaction_form"; // View for transaction creation form
    }

    @PostMapping("/transaction/save")
    public String saveTransaction(@RequestParam double amount,
                                   @RequestParam String paymentMethod,
                                   @RequestParam String status,
                                   Model model) {
        // Create and save a new transaction
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setPaymentMethod(paymentMethod);
        transaction.setStatus(status);

        transactionService.saveTransaction(transaction);
        return "redirect:/transactions"; // Redirect to the list of transactions after saving
    }

    @GetMapping("/transaction/delete/{id}")
    public String deleteTransaction(@PathVariable int id) {
        // Delete the transaction by ID
        transactionService.deleteTransactionById(id);
        return "redirect:/transactions"; // Redirect back to the transaction list
    }
}

    

