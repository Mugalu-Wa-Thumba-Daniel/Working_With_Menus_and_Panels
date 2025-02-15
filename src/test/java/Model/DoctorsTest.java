package Model;

import static org.junit.jupiter.api.Assertions.*;

class DoctorsTest {

    @org.junit.jupiter.api.Test
    void getId() {
        assertEquals(001, new Doctors(001, "Divine", "Heart").getId(),
                "The id should be the same with the one you entered  in the system");
    }

    @org.junit.jupiter.api.Test
    void getName() {
    Doctors doc=new Doctors(33,"","Ear,Nose,Throat");
    String actualName=doc.getName();
    String ExpectedName="";
    assertEquals("","Fareek");


    }

    @org.junit.jupiter.api.Test
    void getSpecialisation() {
    Doctors doc=new Doctors(75,"Mr Enock","Networks");
    String actualSpecialistion=doc.getSpecialisation();
    assertNotNull(actualSpecialistion,"Must fill in field");
    assertFalse(actualSpecialistion.isEmpty());

    }
}