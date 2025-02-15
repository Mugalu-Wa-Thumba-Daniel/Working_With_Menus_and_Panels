package Views;

import Model.Doctors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class IntegrationTest1 {

    private HomePanel homePanel;
    private DoctorsPanel doctorsPanel;
    private List<Doctors> doctorsList;

    @BeforeEach
    void setUp() {
        homePanel = new HomePanel();
        doctorsList = new ArrayList<>();
        doctorsList.add(new Doctors(20, "Dr. Emma", "Anesthesiology"));
        doctorsList.add(new Doctors(76, "Dr. Divine", "Pediatrics"));
        doctorsPanel = new DoctorsPanel(doctorsList);
    }
    @Test
    void testHomePanelVisibilityIntegration() {
        homePanel.setVisible(true);
        assertTrue(homePanel.isVisible(), "Home panel opened successfully");

        homePanel.setVisible(false);
        assertFalse(homePanel.isVisible(), "Home panel not seen!!");
    }
    @Test
    void testDoctorsPanelIntegration() {
        doctorsPanel.addDoctor();
        assertEquals(3, doctorsList.size(), "The list will be updated with the given changes, forexample 3 now");

        doctorsPanel.deleteDoctor();
        assertEquals(2, doctorsList.size(), "The contents reduce according to the number being removed!");
    }
}
