import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

// Item class
class Item {
    String name;
    int quantity;
    double price;

    Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

// Main GUI class
public class InventoryGUI extends JFrame {

    private JTextField nameField, quantityField, priceField;
    private DefaultTableModel tableModel;
    private JTable table;
    private ArrayList<Item> inventory;

    public InventoryGUI() {
        inventory = new ArrayList<>();

        setTitle("Inventory Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel (Form)
        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("Item Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        panel.add(quantityField);

        panel.add(new JLabel("Price:"));
        priceField = new JTextField();
        panel.add(priceField);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        panel.add(addBtn);
        panel.add(updateBtn);

        add(panel, BorderLayout.NORTH);

        // Table
        tableModel = new DefaultTableModel(new String[]{"Name", "Quantity", "Price"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(deleteBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        // Add Button Action
        addBtn.addActionListener(e -> addItem());

        // Update Button Action
        updateBtn.addActionListener(e -> updateItem());

        // Delete Button Action
        deleteBtn.addActionListener(e -> deleteItem());

        setVisible(true);
    }

    // Add Item
    private void addItem() {
        try {
            String name = nameField.getText();
            int qty = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());

            Item item = new Item(name, qty, price);
            inventory.add(item);

            tableModel.addRow(new Object[]{name, qty, price});
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }

    // Update Item
    private void updateItem() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow >= 0) {
            try {
                String name = nameField.getText();
                int qty = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());

                inventory.set(selectedRow, new Item(name, qty, price));

                tableModel.setValueAt(name, selectedRow, 0);
                tableModel.setValueAt(qty, selectedRow, 1);
                tableModel.setValueAt(price, selectedRow, 2);

                clearFields();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to update");
        }
    }

    // Delete Item
    private void deleteItem() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow >= 0) {
            inventory.remove(selectedRow);
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to delete");
        }
    }

    // Clear Input Fields
    private void clearFields() {
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    // Main Method
    public static void main(String[] args) {
        new InventoryGUI();
    }
}