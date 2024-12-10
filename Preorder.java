import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class ReloGUI extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private ArrayList<String> selectedItems = new ArrayList<>();
    private HashMap<String, Integer> itemPrices = new HashMap<>();
    private int totalCost = 0;

    public ReloGUI() {
        setTitle("RELO: Plan your day, your way!");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Populate itemPrices with random costs
        String[] menuItems = {"Burger", "Pizza", "Salad", "Pasta", "Coffee", "Sandwich", "Fries", "Juice", "Cake", "Ice Cream"};
        for (String item : menuItems) {
            itemPrices.put(item, (int) (Math.random() * 151) + 50); // Random price between ₹50 and ₹200
        }

        // Create panels for Sign In, Sign Up, Dashboard, Cafe Selection, Date/Time Selection, Menu, Summary, Payment, and Card Details
        JPanel signInPanel = createSignInPanel();
        JPanel signUpPanel = createSignUpPanel();
        JPanel dashboardPanel = createDashboardPanel();
        JPanel cafeSelectionPanel = createCafeSelectionPanel();
        JPanel dateTimeSelectionPanel = createDateTimeSelectionPanel();
        JPanel menuPanel = createMenuPanel();
        JPanel summaryPanel = createSummaryPanel();
        JPanel paymentPanel = createPaymentPanel();
        JPanel cardDetailsPanel = createCardDetailsPanel();

        // Add panels to main panel with card layout
        mainPanel.add(signInPanel, "Sign In");
        mainPanel.add(signUpPanel, "Sign Up");
        mainPanel.add(dashboardPanel, "Dashboard");
        mainPanel.add(cafeSelectionPanel, "Cafe Selection");
        mainPanel.add(dateTimeSelectionPanel, "Date/Time Selection");
        mainPanel.add(menuPanel, "Menu");
        mainPanel.add(summaryPanel, "Summary");
        mainPanel.add(paymentPanel, "Payment");
        mainPanel.add(cardDetailsPanel, "Card Details");

        add(mainPanel, BorderLayout.CENTER);

        // Initial display of Sign In panel
        cardLayout.show(mainPanel, "Sign In");

        setVisible(true);
    }

    private JPanel createSignInPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Sign In");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Mobile Number:"), gbc);

        gbc.gridx = 1;
        JTextField mobileField = new JTextField(15);
        panel.add(mobileField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("OTP:"), gbc);

        gbc.gridx = 1;
        JTextField otpField = new JTextField(15);
        panel.add(otpField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JButton signInButton = new JButton("Sign In");
        panel.add(signInButton, gbc);

        gbc.gridy = 4;
        JButton goToSignUpButton = new JButton("Go to Sign Up");
        panel.add(goToSignUpButton, gbc);

        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mobile = mobileField.getText();
                String otp = otpField.getText();
                JOptionPane.showMessageDialog(null, "Signing in with Mobile: " + mobile + " OTP: " + otp);

                // Switch to Dashboard panel
                cardLayout.show(mainPanel, "Dashboard");
            }
        });

        goToSignUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Sign Up");
            }
        });

        return panel;
    }

    private JPanel createSignUpPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        JTextField usernameField = new JTextField(15);
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Mobile Number:"), gbc);

        gbc.gridx = 1;
        JTextField mobileField = new JTextField(15);
        panel.add(mobileField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Gender:"), gbc);

        gbc.gridx = 1;
        JComboBox<String> genderBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        panel.add(genderBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("OTP:"), gbc);

        gbc.gridx = 1;
        JTextField otpField = new JTextField(15);
        panel.add(otpField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JButton signUpButton = new JButton("Sign Up");
        panel.add(signUpButton, gbc);

        gbc.gridy = 6;
        JButton goToSignInButton = new JButton("Go to Sign In");
        panel.add(goToSignInButton, gbc);

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String mobile = mobileField.getText();
                String gender = (String) genderBox.getSelectedItem();
                String otp = otpField.getText();
                JOptionPane.showMessageDialog(null, "Signing up with Username: " + username + ", Mobile: " + mobile + ", Gender: " + gender + ", OTP: " + otp);

                // Switch to Dashboard panel
                cardLayout.show(mainPanel, "Dashboard");
            }
        });

        goToSignInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Sign In");
            }
        });

        return panel;
    }

    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        JLabel titleLabel = new JLabel("Dashboard", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton preOrderButton = new JButton("Pre Order");
        JButton eventsButton = new JButton("Events");

        panel.add(titleLabel);
        panel.add(preOrderButton);
        panel.add(eventsButton);

        preOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Cafe Selection");
            }
        });

        eventsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Events clicked");
            }
        });

        return panel;
    }

    private JPanel createCafeSelectionPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        JLabel titleLabel = new JLabel("Select Cafe or Restaurant", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        String[] cafes = {"Theory Cafe", "Autumn Leaf Cafe", "Cravery Cafe", "Farzi Cafe",
                "Cafe Graffiti", "Nidhivan", "Kholani's Restaurant", "Amara", "Mazo", "Pista House"};

        for (String cafe : cafes) {
            JButton cafeButton = new JButton(cafe);
            cafeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(mainPanel, "Date/Time Selection");
                    JOptionPane.showMessageDialog(null, "Selected: " + cafe);
                }
            });
            panel.add(cafeButton);
        }

        return panel;
    }

    private JPanel createDateTimeSelectionPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel titleLabel = new JLabel("Select Date and Time", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel fieldsPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        JTextField dateField = new JTextField("Select Date (e.g., 2023-11-10)");
        JTextField timeField = new JTextField("Select Time (e.g., 19:00)");
        JButton confirmButton = new JButton("Confirm");

        fieldsPanel.add(dateField);
        fieldsPanel.add(timeField);
        fieldsPanel.add(confirmButton);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(fieldsPanel, BorderLayout.CENTER);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Menu");
            }
        });

        return panel;
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel titleLabel = new JLabel("Menu", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel menuItemsPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        String[] menuItems = {"Burger", "Pizza", "Salad", "Pasta", "Coffee", "Sandwich", "Fries", "Juice", "Cake", "Ice Cream"};

        for (String item : menuItems) {
            JCheckBox menuItemCheckBox = new JCheckBox(item + " - ₹" + itemPrices.get(item)); // Display the cost directly in the menu item
            menuItemCheckBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (menuItemCheckBox.isSelected()) {
                        selectedItems.add(item + " - ₹" + itemPrices.get(item)); // Append item with cost
                        totalCost += itemPrices.get(item);
                    } else {
                        selectedItems.remove(item + " - ₹" + itemPrices.get(item)); // Remove item with cost
                        totalCost -= itemPrices.get(item);
                    }
                }
            });
            menuItemsPanel.add(menuItemCheckBox);
        }

        JButton showSummaryButton = new JButton("Show Summary");
        showSummaryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Summary");
            }
        });

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(menuItemsPanel, BorderLayout.CENTER);
        panel.add(showSummaryButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createSummaryPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel titleLabel = new JLabel("Summary", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JTextArea summaryArea = new JTextArea(10, 30);
        summaryArea.setEditable(false);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(summaryArea), BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Menu");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Menu");
            }
        });
        panel.add(backButton, BorderLayout.SOUTH);

        JButton paymentButton = new JButton("Proceed to Payment");
        paymentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Payment");
            }
        });
        panel.add(paymentButton, BorderLayout.EAST);

        // Add a listener to update the summary when the panel is shown
        panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                StringBuilder summary = new StringBuilder("You have selected:\n");
                for (String item : selectedItems) {
                    summary.append("- ").append(item).append("\n");
                }
                summary.append("\nTotal: ₹").append(totalCost);
                summaryArea.setText(summary.toString());
            }
        });

        return panel;
    }

    private JPanel createPaymentPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel titleLabel = new JLabel("Payment", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton payHalfButton = new JButton("Pay 50% of Bill");
        JButton creditCardDetailsButton = new JButton("Give Credit Card Details");

        buttonsPanel.add(payHalfButton);
        buttonsPanel.add(creditCardDetailsButton);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(buttonsPanel, BorderLayout.CENTER);

        payHalfButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int halfCost = totalCost / 2;
                JOptionPane.showMessageDialog(null, "You chose to pay 50% of the bill: ₹" + halfCost);
            }
        });

        creditCardDetailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Card Details");
            }
        });

        JButton backButton = new JButton("Back to Summary");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Summary");
            }
        });
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createCardDetailsPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        JLabel titleLabel = new JLabel("Card Details", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField nameField = new JTextField();
        JTextField expiryField = new JTextField();
        JTextField cvvField = new JTextField();

        panel.add(new JLabel("Name on Card:"));
        panel.add(nameField);
        panel.add(new JLabel("Expiry Date (MM/YY):"));
        panel.add(expiryField);
        panel.add(new JLabel("CVV:"));
        panel.add(cvvField);

        JButton backButton = new JButton("Back to Payment");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Payment");
            }
        });

        JButton doneButton = new JButton("Done");
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Card Details Submitted");
                // You can add further functionality here to process the payment or confirm the card details.
            }
        });

        panel.add(backButton);
        panel.add(doneButton);

        return panel;
    }

    public static void main(String[] args) {
        new ReloGUI();
    }
}
