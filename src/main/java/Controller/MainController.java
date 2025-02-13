package Controller;

import Model.Doctors;
import Model.Patients;
import Views.DoctorsPanel;
import Views.PatientsPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MainController handles the navigation between different views and manages data interactions.
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
     * Shows the doctors view.
     */
    public void showDoctorsView() {
        DoctorsPanel doctorsPanel = new DoctorsPanel(doctorsList);
        doctorsPanel.setVisible(true);
    }

    /**
     * Shows the patients view.
     */
    public void showPatientsView() {
        PatientsPanel patientsPanel = new PatientsPanel(patientsList);
        patientsPanel.setVisible(true);
    }

    public List<Doctors> getDoctorsList() {
        return doctorsList;
    }

    public List<Patients> getPatientsList() {
        return patientsList;
    }
}
