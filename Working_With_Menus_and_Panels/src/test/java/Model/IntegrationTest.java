package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    @Test
    void testDoctorsAndPatientsIntegration() {
        Doctors doc1 = new Doctors(1, "Dr. Enock", "Heart");
        Doctors doc = new Doctors(2, "Dr. Fareek", "Ear, Nose, Throat");

        Patients pat = new Patients(101, "mr Wanaxe", 23, "Heart problem");
        Patients patt = new Patients(102, "Miss Edith", 35, "Hearing issue");

        assertEquals("Dr. Enock", doc1.getName(), "Search Not Found!!");
        assertEquals("Heart", doc1.getSpecialisation(), "There is an error in the results!!");
        assertEquals("Dr. Fareek", doc.getName(), "Incorrect Name Entered.");
        assertEquals("Ear, Nose, Throat", doc.getSpecialisation());

        assertEquals("mr Wanaxe", pat.getName(), "No results Found..");
        assertEquals(23, pat.getAge(), "Patient 1 age mismatch.");
        assertEquals("Heart problem", pat.getDiagnosis(), "The results do not match with the ones in the system!");
        assertEquals("Miss Edith", patt.getName(), "Patient 2 name mismatch.");
        assertEquals(35, patt.getAge(), "Incorrect Age Entered,, Try again please!!");
        assertEquals("Hearing issue", patt.getDiagnosis(), "Error!! Results Not Found");

        String assign = assignPatientToDoctor(pat, doc1);
        String assignee = assignPatientToDoctor(patt, doc);

        assertEquals("mr Wanaxe is assigned to Dr. Enock (Heart)", assign, "The Doctor is not available please, thank you!!");
        assertEquals("Miss Edith is assigned to Dr. Fareek (Ear, Nose, Throat)", assignee, "Cant Find the Doctors Name currently! Try Again");
    }
    private String assignPatientToDoctor(Patients patient, Doctors doctor) {
        return patient.getName() + " has been assigned to " + doctor.getName() + " (" + doctor.getSpecialisation() + ")";
    }
}
