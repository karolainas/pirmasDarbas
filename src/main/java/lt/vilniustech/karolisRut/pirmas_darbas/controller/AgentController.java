package lt.vilniustech.karolisRut.pirmas_darbas.controller;

import lt.vilniustech.karolisRut.pirmas_darbas.model.Agent;
import lt.vilniustech.karolisRut.pirmas_darbas.db.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST Controller that manages operations for entity: {@link Agent}.
 * <p>Provides endpoints to fetch agents in JSON format with server port.</p>
 */
@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;

    @Value("${server.port}")
    private int serverPort;

    /**
     * Retrieves a list of agents filtered by optional parameters.
     * <p>If no filters are provided, all agents are returned.</p>
     *
     * @param firstname (optional) The first name of the agent.
     * @param lastname  (optional) The last name of the agent.
     * @param email     (optional) The email of the agent.
     * @return A map containing server port and the list of agents.
     */
    @GetMapping(value = "/getAgentsAsJson", produces = "application/json")
    public Map<String, Object> getAgentsAsJson(@RequestParam(required = false) String firstname,
                                               @RequestParam(required = false) String lastname,
                                               @RequestParam(required = false) String email) {
        List<Agent> agents;

        if (firstname != null) {
            agents = agentRepository.findByFirstnameIgnoreCase(firstname);
        } else if (lastname != null) {
            agents = agentRepository.findByLastnameIgnoreCase(lastname);
        } else if (email != null) {
            agents = agentRepository.findByEmailIgnoreCase(email);
        } else {
            agents = agentRepository.findAll();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("port", serverPort);
        response.put("agents", agents);
        return response;
    }
}
