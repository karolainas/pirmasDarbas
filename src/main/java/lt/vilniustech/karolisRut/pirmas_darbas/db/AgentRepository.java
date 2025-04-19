package lt.vilniustech.karolisRut.pirmas_darbas.db;

import lt.vilniustech.karolisRut.pirmas_darbas.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing entity: {@link Agent}.
 * <p>
 * This interface extends {@link JpaRepository}, providing built-in CRUD operations.
 * It also includes custom query methods for searching agents by specific attributes.
 * </p>
 */
public interface AgentRepository extends JpaRepository<Agent, Long> {
    /**
     * Finds a list of agents by their first name, ignoring case sensitivity.
     *
     * @param firstname The first name of the agent.
     * @return A list of agents with the given first name (case-insensitive).
     */
    List<Agent> findByFirstnameIgnoreCase(String firstname);

    /**
     * Finds a list of agents by their last name, ignoring case sensitivity.
     *
     * @param lastname The last name of the agent.
     * @return A list of agents with the given last name (case-insensitive).
     */
    List<Agent> findByLastnameIgnoreCase(String lastname);

    /**
     * Finds a list of agents by their email, ignoring case sensitivity.
     *
     * @param email The email address of the agent.
     * @return A list of agents with the given email (case-insensitive).
     */
    List<Agent> findByEmailIgnoreCase(String email);
}
