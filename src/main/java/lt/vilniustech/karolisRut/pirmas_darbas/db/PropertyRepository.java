package lt.vilniustech.karolisRut.pirmas_darbas.db;

import lt.vilniustech.karolisRut.pirmas_darbas.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
