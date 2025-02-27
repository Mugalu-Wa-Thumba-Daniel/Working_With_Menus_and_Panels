package Model;

/**
 * Doctors class represents a doctor with their attributes.
 * It includes details such as ID, name, and specialisation.
 */
public class Doctors {
    private int id;
    private String name;
    private String specialisation;

    // Constructor
    public Doctors(int id, String name, String specialisation) {
        this.id = id;
        this.name = name;
        this.specialisation = specialisation;
    }
  
    // Getter and Setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for Specialisation
    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    // Override toString method to display doctor details
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialisation='" + specialisation + '\'' +
                '}';
    }
}
