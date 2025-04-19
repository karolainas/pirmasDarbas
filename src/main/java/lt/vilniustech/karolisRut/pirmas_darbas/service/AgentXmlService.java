package lt.vilniustech.karolisRut.pirmas_darbas.service;

import lt.vilniustech.karolisRut.pirmas_darbas.db.AgentRepository;
import lt.vilniustech.karolisRut.pirmas_darbas.model.Agent;
import lt.vilniustech.karolisRut.pirmas_darbas.model.AgentListWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

/**
 * Service class responsible for converting agent data into XML format.
 * <p>
 * This service retrieves agent data from the database using {@link AgentRepository}
 * and provides methods to transform individual agents or lists of agents into XML.
 * </p>
 */
@Service
public class AgentXmlService {

    /**
     * Repository for accessing agent data from the database.
     */
    @Autowired
    private AgentRepository agentRepository;

    /**
     * Retrieves all agents from the database and converts them into an XML-formatted string.
     * <p>
     * The agents are wrapped in an {@link AgentListWrapper} before being marshaled into XML.
     * </p>
     *
     * @return A formatted XML string containing all agents.
     * @throws JAXBException If an error occurs during XML conversion.
     */
    public String getAgentsAsXml() throws JAXBException {
        List<Agent> agents = agentRepository.findAll();
        AgentListWrapper wrapper = new AgentListWrapper(agents);

        JAXBContext context = JAXBContext.newInstance(AgentListWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(wrapper, writer);
        return writer.toString();
    }

    /**
     * Converts a single agent instance into an XML format and prints it to the system output.
     * <p></p>
     * @param agent The agent to be transformed into XML.
     * @throws JAXBException If an error occurs during XML conversion.
     * @deprecated Use {@link #getAgentsAsXml()}. This method is kept only for debugging and some development purposes.
     */
    @Deprecated
    public void transformToXml(Agent agent) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Agent.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(agent, System.out);
    }
}
