package us.mccrory.pi4jdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pi4jdemoApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(Pi4jdemoApplication.class);

	@Autowired
	private PiSystemInfoService piSystemInfoService;

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(Pi4jdemoApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");
		piSystemInfoService.getPiSystemStatus();
	}

}