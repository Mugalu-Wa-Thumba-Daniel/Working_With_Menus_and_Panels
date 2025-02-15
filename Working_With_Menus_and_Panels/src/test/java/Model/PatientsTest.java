package Model;

import org.junit.jupiter.api.Test;

import javax.lang.model.element.Name;

import static org.junit.jupiter.api.Assertions.*;

class PatientsTest {

    private String name;

    @Test
    void setId() {
    Patients pat=new Patients(34,"Mr JohnPaul",20,"Flu");
    pat.setId(37);
    assertEquals(37,pat.getId());
    }

    @Test
    public void setName() {
        String name = "Arnold";
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be null or empty.");
        }
        this.name= name;
    }

    @Test
    void setAge() {
        Patients pat=new Patients(23,"Merinah",45,"Headache");
        pat.setAge(78);
        assertEquals("45",pat.getAge());
    }

    @Test
    void setDiagnosis() {
        Patients patt=new Patients(88,"Mr Cliff",45,"Heart issuse");
        patt.getDiagnosis();
        assertEquals("Heart problem",patt.getDiagnosis());
    }
   }