package lt.vilniustech.karolisRut.pirmas_darbas.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String suffix;

    @OneToMany
    @JoinTable(
            name = "customer_account",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private List<Agent> accounts;

    public Appointment() {}

    public Appointment(int id, String firstName, String lastName, String suffix) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getSuffix() { return suffix; }
    public void setSuffix(String suffix) { this.suffix = suffix; }
}