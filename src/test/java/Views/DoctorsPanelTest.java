package Views;

import Model.Doctors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorsPanelTest {
    private DoctorsPanel doctorsPanel;
    private List<Doctors> doctorsList;

    @BeforeEach
    void setUp() {
        doctorsList = new ArrayList<>();
        doctorsList.add(new Doctors(1, "Dr. Smith", "Cardiology"));
        doctorsList.add(new Doctors(2, "Dr. Johnson", "Neurology"));
        doctorsPanel = new DoctorsPanel(doctorsList);
    }
    @Test
    void testAddDoctor() {
        doctorsPanel.addDoctor();
        assertEquals(3, doctorsList.size(), "List should now contain the newly added name.");
    }
    @Test
    void testDeleteDoctor() {
        doctorsPanel.deleteDoctor();
        assertEquals(1, doctorsList.size(), "Doctor list should have 1 doctor after deletion.");
    }

}