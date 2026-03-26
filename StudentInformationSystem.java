import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentInformationSystem {

    private JFrame frame;
    private JTextField idField, nameField, ageField, courseField;
    private JTable table;
    private DefaultTableModel model;

    public StudentInformationSystem() {
        frame = new JFrame("Student Information System");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top Panel (Form)
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Course:"));
        courseField = new JTextField();
        panel.add(courseField);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");
        JButton clearBtn = new JButton("Clear");

        panel.add(addBtn);
        panel.add(updateBtn);

        frame.add(panel, BorderLayout.NORTH);

        // Table
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Name", "Age", "Course"});
        table = new JTable(model);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Bottom Panel (Buttons)
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(deleteBtn);
        bottomPanel.add(clearBtn);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        // =========================
        // BUTTON EVENTS (CRUD)
        // =========================

        // ADD
        addBtn.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String age = ageField.getText();
            String course = courseField.getText();

            if (id.isEmpty() || name.isEmpty() || age.isEmpty() || course.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields!");
            } else {
                model.addRow(new Object[]{id, name, age, course});
                clearFields();
            }
        });

        // UPDATE
        updateBtn.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();

            if (selectedRow >= 0) {
                model.setValueAt(idField.getText(), selectedRow, 0);
                model.setValueAt(nameField.getText(), selectedRow, 1);
                model.setValueAt(ageField.getText(), selectedRow, 2);
                model.setValueAt(courseField.getText(), selectedRow, 3);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(frame, "Select a row to update!");
            }
        });

        // DELETE
        deleteBtn.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a row to delete!");
            }
        });

        // CLEAR
        clearBtn.addActionListener(e -> clearFields());

        // When table row clicked → fill text fields
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                idField.setText(model.getValueAt(selectedRow, 0).toString());
                nameField.setText(model.getValueAt(selectedRow, 1).toString());
                ageField.setText(model.getValueAt(selectedRow, 2).toString());
                courseField.setText(model.getValueAt(selectedRow, 3).toString());
            }
        });

        frame.setVisible(true);
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        courseField.setText("");
    }

    public static void main(String[] args) {
        new StudentInformationSystem();
    }
}