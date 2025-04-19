package lt.vilniustech.karolisRut.pirmas_darbas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.util.List;

/**
 * Entity class representing an agent in the real estate system.
 * <p>
 * This class is mapped to the {@code agent} table in the database and supports
 * serialization to both JSON and XML formats. It includes attributes such as
 * name, email, license, and relationships to appointments, listings, sellers,
 * and transactions.
 * </p>
 */
@Entity
@Table(name = "agent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement(name = "agent")
@XmlAccessorType(XmlAccessType.FIELD)
public class Agent {

    /**
     * Unique identifier for the agent.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    @XmlElement(name = "id")
    private Long id;

    /**
     * First name of the agent.
     */
    @JsonProperty("firstname")
    @XmlElement(name = "firstname")
    private String firstname;

    /**
     * Last name of the agent.
     */
    @JsonProperty("lastname")
    @XmlElement(name = "lastname")
    private String lastname;

    /**
     * Email address of the agent.
     */
    @JsonProperty("email")
    @XmlElement(name = "email")
    private String email;

    /**
     * License number of the agent.
     */
    @JsonProperty("license")
    @XmlElement(name = "license")
    private String license;

    /**
     * The number of properties the agent has sold.
     */
    @JsonProperty("properties_sold")
    @XmlElement(name = "properties_sold")
    private int propertiesSold;

    /**
     * List of appointments associated with the agent.
     * <p>
     * One agent can have multiple appointments.
     * </p>
     */
    @JsonProperty("appointments")
    @XmlElement(name = "appointments")
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;
}
