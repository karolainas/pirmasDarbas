package lt.vilniustech.karolisRut.pirmas_darbas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;

import java.util.List;

/**
 * Entity class representing a property in the real estate system.
 * <p>
 * This class is mapped to the {@code property} table in the database and
 * supports serialization to both JSON and XML formats. Each property can
 * be associated with multiple {@link Appointment}, and
 * records.
 * </p>
 */
@Entity
@Table(name = "property")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Property {

    /**
     * Unique identifier for the property.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    @XmlElement(name = "id")
    private Long id;

    /**
     * The address of the property.
     */
    @JsonProperty("address")
    @XmlElement(name = "address")
    private String address;

    /**
     * The type of the property (e.g., "Apartment", "House", "Commercial").
     */
    @JsonProperty("types")
    @XmlElement(name = "types")
    private String type;

    /**
     * The size of the property in square meters.
     */
    @JsonProperty("size")
    @XmlElement(name = "size")
    private int size;

    /**
     * The listed price of the property.
     */
    @JsonProperty("price")
    @XmlElement(name = "price")
    private float price;

    /**
     * A brief description of the property.
     */
    @JsonProperty("description")
    @XmlElement(name = "description")
    private String description;

    /**
     * The current status of the property (e.g., "Available", "Sold").
     */
    @JsonProperty("status")
    @XmlElement(name = "status")
    private String status;

    /**
     * List of appointments scheduled for viewing this property.
     * <p>
     * A property can have multiple appointments.
     * </p>
     */
    @JsonProperty("appointments")
    @XmlElement(name = "appointments")
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;
}
