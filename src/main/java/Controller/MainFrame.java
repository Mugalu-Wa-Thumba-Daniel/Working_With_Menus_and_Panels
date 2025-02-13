package Controller;

import Views.HomePanel;
import Views.PatientsPanel;
import Views.DoctorsPanel;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import Model.Doctors;
import Model.Patients;

/**
 * MainFrame is the main window of the application.
 * It sets up the user interface and navigation.
 */
public class MainFrame extends JFrame {
    private MainController mainController;
    private List<Doctors> doctorsList;
    private List<Patients> patientsList;

    public MainFrame() {
        setTitle("Hospital Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        mainController = new MainController(this); // Initialize MainController

        configureMenuBar();
        configureMainPanel();
        setVisible(true);

        // Show the home panel on startup
        mainController.showCard("homeCard");
    }

    /**
     * Configures the menu bar with menu items and their actions.
     */
    private void configureMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem homeItem = new JMenuItem("Home");
        JMenuItem patientsItem = new JMenuItem("Patients");
        JMenuItem doctorsItem = new JMenuItem("Doctors");

        homeItem.addActionListener(e -> mainController.showCard("homeCard"));
        patientsItem.addActionListener(e -> mainController.showCard("patientsCard"));
        doctorsItem.addActionListener(e -> mainController.showCard("doctorsCard"));

        menu.add(homeItem);
        menu.add(patientsItem);
        menu.add(doctorsItem);
        menuBar.add(menu);

        setJMenuBar(menuBar);
    }

    /**
     * Configures the main panel with different card panels.
     */
    private void configureMainPanel() {
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        HomePanel homePanel = new HomePanel(this);
        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.add(new JLabel("Principal Menu", JLabel.CENTER), BorderLayout.NORTH);
        menuPanel.add(new JPanel(), BorderLayout.CENTER); // Placeholder panel

        // Initialize the lists of doctors and patients in MainFrame
        doctorsList = new ArrayList<>();
        patientsList = new ArrayList<>();
        loadSampleData();

        PatientsPanel patientsPanel = new PatientsPanel(cardLayout, mainPanel, patientsList);
        DoctorsPanel doctorsPanel = new DoctorsPanel(cardLayout, mainPanel, doctorsList);

        mainPanel.add(homePanel, "homeCard");
        mainPanel.add(menuPanel, "menuCard");
        mainPanel.add(patientsPanel, "patientsCard");
        mainPanel.add(doctorsPanel, "doctorsCard");

        add(mainPanel);
    }

    /**
     * Loads sample data for doctors and patients.
     */
    private void loadSampleData() {
        doctorsList.add(new Doctors(1, "Dr. Alice Brown", "Cardiology"));
        doctorsList.add(new Doctors(2, "Dr. Bob Johnson", "Neurology"));

        patientsList.add(new Patients(1, "John Doe", 25, "Flu"));
        patientsList.add(new Patients(2, "Jane Smith", 30, "Fracture"));
    }
}
