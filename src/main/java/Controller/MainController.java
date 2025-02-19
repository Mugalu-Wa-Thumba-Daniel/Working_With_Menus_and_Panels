package Controller;

import Model.Doctors;
import Model.Patients;
import Views.HomePanel;
import Views.PatientsPanel;
import Views.DoctorsPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MainController handles the navigation between different panels and manages data interactions.
 */
public class MainController {
    private JFrame mainFrame;
    private List<Doctors> doctorsList;
    private List<Patients> patientsList;

    public MainController(JFrame frame) {
        this.mainFrame = frame;
        this.doctorsList = new ArrayList<>();
        this.patientsList = new ArrayList<>();

        loadSampleData();
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

    /**
     * Displays the specified card panel.
     *
     * @param cardName the name of the card panel to display
     */
    public void showCard(String cardName) {
        CardLayout cardLayout = (CardLayout) ((JPanel) mainFrame.getContentPane().getComponent(0)).getLayout();
        cardLayout.show((JPanel) mainFrame.getContentPane().getComponent(0), cardName);
    }

    public List<Doctors> getDoctorsList() {
        return doctorsList;
    }

    public List<Patients> getPatientsList() {
        return patientsList;
    }
}