package lt.vilniustech.karolisRut.pirmas_darbas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point of the PSP Project application.
 * <p>
 * This class is responsible for bootstrapping the Spring Boot application.
 * </p>
 *
 * @author Karolis Rutkauskas
 * @version 1.0
 * @since 2025-04-15
 */
@SpringBootApplication
public class PirmasDarbasApplication {

	/**
	 * The main method that starts the Spring Boot application.
	 *
	 * @param args Command-line arguments passed during application startup.
	 */
	public static void main(String[] args) {
		SpringApplication.run(PirmasDarbasApplication.class, args);
	}

}
