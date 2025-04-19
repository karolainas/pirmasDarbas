package lt.vilniustech.karolisRut.pirmas_darbas.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Wrapper class for a list of {@link Agent} objects.
 * <p>
 * This class is used for XML serialization to encapsulate multiple agents
 * under a single root element in an XML document.
 * </p>
 */
@Getter
@Setter
@XmlRootElement(name = "agents")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgentListWrapper {

    /**
     * List of agents to be serialized into XML.
     */
    private List<Agent> agents;

    /**
     * Default no-argument constructor required for JAXB.
     */
    public AgentListWrapper() {}

    /**
     * Constructs an {@code AgentListWrapper} with a specified list of agents.
     *
     * @param agents The list of agents to be wrapped.
     */
    public AgentListWrapper(List<Agent> agents) {
        this.agents = agents;
    }
}