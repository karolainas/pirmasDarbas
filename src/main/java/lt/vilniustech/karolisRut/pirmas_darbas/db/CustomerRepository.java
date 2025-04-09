package lt.vilniustech.karolisRut.pirmas_darbas.db;

import lt.vilniustech.karolisRut.pirmas_darbas.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Appointment, Long> {
}
