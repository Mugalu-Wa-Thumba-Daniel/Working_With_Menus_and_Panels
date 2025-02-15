package Views;

import Controller.MainFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import Model.Doctors;
import Controller.MainController;

/**
 * DoctorsPanel is the panel that displays the list of doctors.
 * It includes a table with doctor data and buttons for Add, Edit, Delete, and Refresh.
 */
public class DoctorsPanel {
    private JFrame frame;
    private JTable table;
    private List<Doctors> doctorsList;
    private DefaultTableModel tableModel;

    public DoctorsPanel(List<Doctors> doctorsList) {
        frame = new JFrame("Doctors List");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        this.doctorsList = doctorsList;
        frame.setLayout(new BorderLayout());

        configureMenuBar();
        configureLabel();
        configureTable();
        configureButtons();
    }

    /**
     * Configures the menu bar with menu items and their actions.
     */
    private void configureMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu navigationMenu = new JMenu("Navigation");
        JMenuItem homeItem = new JMenuItem("Home");
        JMenuItem backItem = new JMenuItem("Back");

        homeItem.addActionListener(e -> {
            HomePanel homePanel = new HomePanel();
            homePanel.setVisible(true);
            frame.dispose();
        });
        backItem.addActionListener(e -> {
            new MainFrame();
            frame.dispose();
        });

        navigationMenu.add(homeItem);
        navigationMenu.add(backItem);

        JMenu manageDataMenu = new JMenu("Manage Data");
        JMenuItem patientsItem = new JMenuItem("Patients");
        JMenuItem doctorsItem = new JMenuItem("Doctors");

        patientsItem.addActionListener(e -> {
            PatientsPanel patientsPanel = new PatientsPanel(new MainController(frame).getPatientsList());
            patientsPanel.setVisible(true);
            frame.dispose();
        });
        doctorsItem.addActionListener(e -> {
            // Stay on the same panel
        });

        manageDataMenu.add(patientsItem);
        manageDataMenu.add(doctorsItem);

        menuBar.add(navigationMenu);
        menuBar.add(manageDataMenu);

        frame.setJMenuBar(menuBar);
    }

    /**
     * Configures the label and adds it to the panel.
     */
    private void configureLabel() {
        JLabel label = new JLabel("Doctors List", JLabel.CENTER);
        frame.add(label, BorderLayout.NORTH);
    }

    /**
     * Configures the table with doctor data and adds it to the panel.
     */
    private void configureTable() {
        String[] columnNames = {"ID", "Name", "Specialisation"};
        tableModel = new DefaultTableModel(columnNames, 0);

        for (Doctors doctor : doctorsList) {
            Object[] row = {doctor.getId(), doctor.getName(), doctor.getSpecialisation()};
            tableModel.addRow(row);
        }

        table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
    }

    /**
     * Configures the buttons and adds them to the panel.
     */
    private void configureButtons() {
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        JButton refreshButton = new JButton("Refresh");

        addButton.addActionListener(e -> addDoctor());
        editButton.addActionListener(e -> editDoctor());
        deleteButton.addActionListener(e -> deleteDoctor());
        refreshButton.addActionListener(e -> refreshDoctors());

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Adds a new doctor to the list and table.
     */
    void addDoctor() {
        int id = doctorsList.size() + 1;
        String name = JOptionPane.showInputDialog("Enter doctor's name:");
        String specialisation = JOptionPane.showInputDialog("Enter doctor's specialisation:");

        if (name != null && specialisation != null) {
            Doctors newDoctor = new Doctors(id, name, specialisation);
            doctorsList.add(newDoctor);
            tableModel.addRow(new Object[]{id, name, specialisation});
        }
    }

    /**
     * Edits the selected doctor in the list and table.
     */
    private void editDoctor() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String name = JOptionPane.showInputDialog("Enter new doctor's name:", tableModel.getValueAt(selectedRow, 1));
            String specialisation = JOptionPane.showInputDialog("Enter new doctor's specialisation:", tableModel.getValueAt(selectedRow, 2));

            if (name != null && specialisation != null) {
                Doctors editedDoctor = doctorsList.get(selectedRow);
                editedDoctor.setName(name);
                editedDoctor.setSpecialisation(specialisation);

                tableModel.setValueAt(name, selectedRow, 1);
                tableModel.setValueAt(specialisation, selectedRow, 2);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a doctor to edit.");
        }
    }

    /**
     * Deletes the selected doctor from the list and table.
     */
    void deleteDoctor() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            doctorsList.remove(selectedRow);
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a doctor to delete.");
        }
    }

    /**
     * Refreshes the list of doctors in the table.
     */
    private void refreshDoctors() {
        tableModel.setRowCount(0);
        for (Doctors doctor : doctorsList) {
            tableModel.addRow(new Object[]{doctor.getId(), doctor.getName(), doctor.getSpecialisation()});
        }
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
