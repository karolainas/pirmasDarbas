package lt.vilniustech.karolisRut.pirmas_darbas.db;

import lt.vilniustech.karolisRut.pirmas_darbas.model.Agent;
import lt.vilniustech.karolisRut.pirmas_darbas.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing entity: {@link Appointment}.
 * <p>
 * WIP.
 * </p>
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long>  {
}
