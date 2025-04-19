package lt.vilniustech.karolisRut.pirmas_darbas.controller;

import lt.vilniustech.karolisRut.pirmas_darbas.model.Agent;
import lt.vilniustech.karolisRut.pirmas_darbas.db.AgentRepository;
import lt.vilniustech.karolisRut.pirmas_darbas.service.AgentXmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.xml.bind.JAXBException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * REST Controller that manages operations for entity: {@link Agent}.
 * <p>Provides endpoints to fetch agents in JSON and XML formats.</p>
 */
@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private AgentXmlService agentXmlService;

    /**
     * Retrieves a list of agents filtered by optional parameters.
     * <p>If no filters are provided, all agents are returned.</p>
     *
     * @param firstname (optional) The first name of the agent.
     * @param lastname  (optional) The last name of the agent.
     * @param email     (optional) The email of the agent.
     * @return A list of agents matching the specified filters.
     */
    @GetMapping(value = "/getAgentsAsJson", produces = "application/json")
    public List<Agent> getAgentsAsJson(@RequestParam(required = false) String firstname, @RequestParam(required = false) String lastname, @RequestParam(required = false) String email) {
        if (firstname != null) {
            return agentRepository.findByFirstnameIgnoreCase(firstname);
        } else if (lastname != null) {
            return agentRepository.findByLastnameIgnoreCase(lastname);
        } else if (email != null) {
            return agentRepository.findByEmailIgnoreCase(email);
        }
        return agentRepository.findAll();
    }

    /**
     * Retrieves a list of agents in XML format and saves it as a file.
     * <p>The generated XML file is stored in the "output" directory.</p>
     *
     * @return A message containing the file path where the XML was saved.
     * @throws JAXBException If an error occurs during XML processing.
     * @throws IOException   If an error occurs while writing the file.
     */
    @GetMapping(value = "/getAgentsAsXml", produces = "text/plain")
    public String getAgentsAsXml() throws JAXBException, IOException {
        List<Agent> agents = agentRepository.findAll();
        String agentsXmlString = agentXmlService.getAgentsAsXml();

        String directoryPath = "./output";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Directory created");
            }
        }

        String filePath = Paths.get(directoryPath, "agents.xml").toString();
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(agentsXmlString);
        }

        return "XML generated at: " + new File(filePath).getAbsolutePath();
    }
}
