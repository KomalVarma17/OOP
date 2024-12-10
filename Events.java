import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Events extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);

    public Events() {
        setTitle("Event Planning");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set overall background color
        mainPanel.setBackground(Color.decode("#f6f6f1"));

        // Create and add panels
        mainPanel.add(createStartPanel(), "Start");
        mainPanel.add(createEventTypeCafePanel(), "Event Type & Cafe Selection");
        mainPanel.add(createDateTimePanel(), "Date & Time Selection");
        mainPanel.add(createVendorSelectionPanel(), "Vendor Selection");
        mainPanel.add(createPaymentPanel(), "Payment");
        mainPanel.add(createCreditCardDetailsPanel(), "Credit Card Details");

        add(mainPanel, BorderLayout.CENTER);
        cardLayout.show(mainPanel, "Start");
        setVisible(true);
    }

    private JPanel createStartPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#f6f6f1"));
        JButton eventsButton = createStyledButton("Events", "#5271ff", "#f26d6f");

        eventsButton.addActionListener(e -> cardLayout.show(mainPanel, "Event Type & Cafe Selection"));

        panel.add(eventsButton);
        return panel;
    }

    private JPanel createEventTypeCafePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.decode("#f6f6f1"));

        JLabel titleLabel = createStyledLabel("Select Event Type and Cafe", 20, "#5271ff");
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        optionsPanel.setBackground(Color.decode("#f6f6f1"));

        JComboBox<String> eventTypeComboBox = new JComboBox<>(new String[]{"Birthday", "Proposal", "Anniversary", "Baby Shower", "Farewell", "Get Togethers"});
        JComboBox<String> cafeComboBox = new JComboBox<>(new String[]{"Cafe Resto", "Farzi Cafe", "Malibu", "Old Tree Cafe", "Olive Bistro", "Theory Cafe", "Nataka"});

        optionsPanel.add(new JLabel("Type of Event:"));
        optionsPanel.add(eventTypeComboBox);
        optionsPanel.add(new JLabel("Select Cafe:"));
        optionsPanel.add(cafeComboBox);

        JButton doneButton = createStyledButton("Done", "#5271ff", "#f26d6f");
        doneButton.addActionListener(e -> cardLayout.show(mainPanel, "Date & Time Selection"));

        panel.add(optionsPanel, BorderLayout.CENTER);
        panel.add(doneButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createDateTimePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.decode("#f6f6f1"));

        JLabel titleLabel = createStyledLabel("Enter Date and Time", 20, "#5271ff");
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel dateTimePanel = new JPanel(new GridLayout(3, 2, 10, 10));
        dateTimePanel.setBackground(Color.decode("#f6f6f1"));

        JTextField dateField = new JTextField("Enter Date (YYYY-MM-DD)");
        JTextField timeField = new JTextField("Enter Time (HH:MM)");

        dateTimePanel.add(new JLabel("Date:"));
        dateTimePanel.add(dateField);
        dateTimePanel.add(new JLabel("Time:"));
        dateTimePanel.add(timeField);

        JButton doneButton = createStyledButton("Done", "#5271ff", "#f26d6f");
        doneButton.addActionListener(e -> cardLayout.show(mainPanel, "Vendor Selection"));

        panel.add(dateTimePanel, BorderLayout.CENTER);
        panel.add(doneButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createVendorSelectionPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.decode("#f6f6f1"));

        JLabel titleLabel = createStyledLabel("Select Vendor", 20, "#5271ff");
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel vendorPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        vendorPanel.setBackground(Color.decode("#f6f6f1"));

        String[] vendors = {"Raghu", "Shankar", "Priya", "Parul"};
        for (String vendor : vendors) {
            JCheckBox vendorCheckBox = new JCheckBox(vendor);
            vendorCheckBox.setBackground(Color.decode("#f6f6f1"));
            vendorPanel.add(vendorCheckBox);
        }

        JButton okButton = createStyledButton("OK", "#5271ff", "#f26d6f");
        okButton.addActionListener(e -> cardLayout.show(mainPanel, "Payment"));

        panel.add(vendorPanel, BorderLayout.CENTER);
        panel.add(okButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createPaymentPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.decode("#f6f6f1"));

        JLabel titleLabel = createStyledLabel("Payment Options", 20, "#5271ff");
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel paymentOptionsPanel = new JPanel(new FlowLayout());
        paymentOptionsPanel.setBackground(Color.decode("#f6f6f1"));

        JButton payHalfButton = createStyledButton("Pay 50% of Bill", "#5271ff", "#f26d6f");
        JButton creditCardDetailsButton = createStyledButton("Give Credit Card Details", "#5271ff", "#f26d6f");

        payHalfButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "You chose to pay 50% of the bill."));
        creditCardDetailsButton.addActionListener(e -> cardLayout.show(mainPanel, "Credit Card Details"));

        paymentOptionsPanel.add(payHalfButton);
        paymentOptionsPanel.add(creditCardDetailsButton);

        panel.add(paymentOptionsPanel, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createCreditCardDetailsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.decode("#f6f6f1"));

        JLabel titleLabel = createStyledLabel("Enter Credit Card Details", 20, "#5271ff");
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel cardDetailsPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        cardDetailsPanel.setBackground(Color.decode("#f6f6f1"));

        JTextField nameField = new JTextField("Name on Card");
        JTextField expiryField = new JTextField("Expiry (MM/YY)");
        JTextField cvvField = new JTextField("CVV");

        cardDetailsPanel.add(new JLabel("Name on Card:"));
        cardDetailsPanel.add(nameField);
        cardDetailsPanel.add(new JLabel("Expiry:"));
        cardDetailsPanel.add(expiryField);
        cardDetailsPanel.add(new JLabel("CVV:"));
        cardDetailsPanel.add(cvvField);

        JButton doneButton = createStyledButton("Done", "#5271ff", "#f26d6f");
        doneButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Credit Card details submitted and slot booked. Thank you!");
            cardLayout.show(mainPanel, "Start");
        });

        panel.add(cardDetailsPanel, BorderLayout.CENTER);
        panel.add(doneButton, BorderLayout.SOUTH);

        return panel;
    }

    private JLabel createStyledLabel(String text, int fontSize, String color) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        label.setForeground(Color.decode(color));
        return label;
    }

    private JButton createStyledButton(String text, String bgColor, String hoverColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBackground(Color.decode(bgColor));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.decode(hoverColor));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.decode(bgColor));
            }
        });

        return button;
    }

    public static void main(String[] args) {
        new Events();
    }
}
