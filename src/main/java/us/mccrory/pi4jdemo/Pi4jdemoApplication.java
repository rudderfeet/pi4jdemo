package us.mccrory.pi4jdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A simple console Pi4J demonstration app using Spring Boot.
 */
@SpringBootApplication
public class Pi4jdemoApplication implements CommandLineRunner {

	/**
	 * An slf4j logging object for this class.
	 */
	private static Logger LOG = LoggerFactory.getLogger(Pi4jdemoApplication.class);

	/**
	 * An auto-injected PiSystemInfoService to make this app slightly less monolithic.
	 */
	@Autowired
	private PiSystemInfoService piSystemInfoService;

	/**
	 * Pi4jdemoApplication's primary entry point.
	 * @param args Command line arguments in the form of a string array
	 */
	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		// Hand-off to this class' run() method
		SpringApplication.run(Pi4jdemoApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	/**
	 * Our app's primary control method, run(), implemented from CommandLineRunner.
	 */
	@Override
	public void run(String... args) throws Exception {

		// Print to log whatever we can find out about the runtime environment.
		piSystemInfoService.getPiSystemStatus();

		if (args != null && args.length > 0 && args[0].startsWith("--runonce")) {
			System.exit(0);
		} else {
			while(true) {
				// Wait 10 seconds
				Thread.sleep(10000);
			}
		}

	}

}