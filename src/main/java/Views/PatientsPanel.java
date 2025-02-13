package Views;

import Controller.MainFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import Model.Patients;
import Controller.MainController;

/**
 * PatientsPanel is the panel that displays the list of patients.
 * It includes a table with patient data and buttons for Add, Edit, Delete, and Refresh.
 */
public class PatientsPanel {
    private JFrame frame;
    private JTable table;
    private List<Patients> patientsList;
    private DefaultTableModel tableModel;

    public PatientsPanel(List<Patients> patientsList) {
        frame = new JFrame("Patients List");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        this.patientsList = patientsList;
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
        JMenuItem doctorsItem = new JMenuItem("Doctors");
        JMenuItem patientsItem = new JMenuItem("Patients");

        doctorsItem.addActionListener(e -> {
            DoctorsPanel doctorsPanel = new DoctorsPanel(new MainController(frame).getDoctorsList());
            doctorsPanel.setVisible(true);
            frame.dispose();
        });
        patientsItem.addActionListener(e -> {
            // Stay on the same panel
        });

        manageDataMenu.add(doctorsItem);
        manageDataMenu.add(patientsItem);

        menuBar.add(navigationMenu);
        menuBar.add(manageDataMenu);

        frame.setJMenuBar(menuBar);
    }

    /**
     * Configures the label and adds it to the panel.
     */
    private void configureLabel() {
        JLabel label = new JLabel("Patients List", JLabel.CENTER);
        frame.add(label, BorderLayout.NORTH);
    }

    /**
     * Configures the table with patient data and adds it to the panel.
     */
    private void configureTable() {
        String[] columnNames = {"ID", "Name", "Age", "Diagnosis"};
        tableModel = new DefaultTableModel(columnNames, 0);

        for (Patients patient : patientsList) {
            Object[] row = {patient.getId(), patient.getName(), patient.getAge(), patient.getDiagnosis()};
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

        addButton.addActionListener(e -> addPatient());
        editButton.addActionListener(e -> editPatient());
        deleteButton.addActionListener(e -> deletePatient());
        refreshButton.addActionListener(e -> refreshPatients());

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Adds a new patient to the list and table.
     */
    private void addPatient() {
        int id = patientsList.size() + 1;
        String name = JOptionPane.showInputDialog("Enter patient's name:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter patient's age:"));
        String diagnosis = JOptionPane.showInputDialog("Enter patient's diagnosis:");

        if (name != null && diagnosis != null) {
            Patients newPatient = new Patients(id, name, age, diagnosis);
            patientsList.add(newPatient);
            tableModel.addRow(new Object[]{id, name, age, diagnosis});
        }
    }

    /**
     * Edits the selected patient in the list and table.
     */
    private void editPatient() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String name = JOptionPane.showInputDialog("Enter new patient's name:", tableModel.getValueAt(selectedRow, 1));
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter new patient's age:", tableModel.getValueAt(selectedRow, 2)));
            String diagnosis = JOptionPane.showInputDialog("Enter new patient's diagnosis:", tableModel.getValueAt(selectedRow, 3));

            if (name != null && diagnosis != null) {
                Patients editedPatient = patientsList.get(selectedRow);
                editedPatient.setName(name);
                editedPatient.setAge(age);
                editedPatient.setDiagnosis(diagnosis);

                tableModel.setValueAt(name, selectedRow, 1);
                tableModel.setValueAt(age, selectedRow, 2);
                tableModel.setValueAt(diagnosis, selectedRow, 3);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a patient to edit.");
        }
    }

    /**
     * Deletes the selected patient from the list and table.
     */
    private void deletePatient() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            patientsList.remove(selectedRow);
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a patient to delete.");
        }
    }

    /**
     * Refreshes the list of patients in the table.
     */
    private void refreshPatients() {
        tableModel.setRowCount(0);
        for (Patients patient : patientsList) {
            tableModel.addRow(new Object[]{patient.getId(), patient.getName(), patient.getAge(), patient.getDiagnosis()});
        }
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
