package lt.vilniustech.karolisRut.pirmas_darbas.db;

import org.springframework.data.jpa.repository.JpaRepository;
import lt.vilniustech.karolisRut.pirmas_darbas.model.Buyer;
import lt.vilniustech.karolisRut.pirmas_darbas.model.Appointment;

public interface BuyerController extends JpaRepository<Buyer, Long> {
}
