package lt.vilniustech.areipsleger.pirmas_darbas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    public Customer(int id, String name, String firstName, String lastName, String suffix) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSuffix() {
        return suffix;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String firstName;
    private String lastName;
    private String suffix;

    public Customer() {

    }
}

