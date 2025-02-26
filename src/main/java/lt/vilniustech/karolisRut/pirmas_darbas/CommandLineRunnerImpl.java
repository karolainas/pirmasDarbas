package lt.vilniustech.karolisRut.pirmas_darbas;

import lt.vilniustech.karolisRut.pirmas_darbas.db.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void run(String... args) throws Exception {
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
    }
}
