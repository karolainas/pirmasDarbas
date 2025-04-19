package lt.vilniustech.karolisRut.pirmas_darbas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;

import java.util.List;

/**
 * Entity class representing a buyer in the real estate system.
 * <p>
 * This class is mapped to the {@code buyer} table in the database and
 * supports serialization to both JSON and XML formats. Each buyer can
 * have multiple appointments and transactions.
 * </p>
 */
@Entity
@Table(name = "buyer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Buyer {

    /**
     * Unique identifier for the buyer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    @XmlElement(name = "id")
    private Long id;

    /**
     * First name of the buyer.
     */
    @JsonProperty("firstname")
    @XmlElement(name = "firstname")
    private String firstname;

    /**
     * Last name of the buyer.
     */
    @JsonProperty("lastname")
    @XmlElement(name = "lastname")
    private String lastname;

    /**
     * Indicates whether the buyer has financing available.
     */
    @JsonProperty("financing")
    @XmlElement(name = "financing")
    private boolean financing;

    /**
     * List of appointments associated with the buyer.
     * <p>
     * A buyer can schedule multiple property viewings.
     * </p>
     */
    @JsonProperty("appointments")
    @XmlElement(name = "appointments")
    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;
}
