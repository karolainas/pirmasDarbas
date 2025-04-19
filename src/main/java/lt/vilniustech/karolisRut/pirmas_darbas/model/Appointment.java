package lt.vilniustech.karolisRut.pirmas_darbas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Entity class representing an appointment in the real estate system.
 * <p>
 * This class is mapped to the {@code appointment} table in the database and
 * supports serialization to both JSON and XML formats. Each appointment
 * is linked to a {@link Property}, a {@link Buyer}, and an {@link Agent}.
 * </p>
 */
@Entity
@Table(name = "appointment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Appointment {

    /**
     * Unique identifier for the appointment.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    @XmlElement(name = "id")
    private Long id;

    /**
     * The date and time of the appointment.
     */
    private LocalDateTime appointmentDate;

    /**
     * Retrieves the formatted appointment date as a string.
     * <p>
     * This is used for XML and JSON serialization.
     * AppointmentDate needs it's own implementation
     * because the serializer cannot properly
     * process the LocalDateTime format.
     * </p>
     *
     * @return A string representation of the appointment date.
     */
    @JsonProperty("appointment_date")
    @XmlElement(name = "appointment_date")
    private String getFormattedAppointmentDate() {
        return appointmentDate != null ? appointmentDate.toString() : null;
    }

    /**
     * The property associated with this appointment.
     * <p>
     * This relationship is managed by a foreign key in the database.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    @XmlTransient
    private Property property;

    /**
     * The buyer involved in this appointment.
     */
    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    @XmlTransient
    private Buyer buyer;

    /**
     * The agent responsible for this appointment.
     */
    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    @XmlTransient
    private Agent agent;
}
