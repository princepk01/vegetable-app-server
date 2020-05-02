package com.app.vegetable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VegatableAppServerApplication {
	private static final Logger logger = LogManager.getLogger(VegatableAppServerApplication.class);
	public static void main(String[] args) {
		logger.debug("this is debug lavel");
		logger.info("Main method starting");
		
		SpringApplication.run(VegatableAppServerApplication.class, args);
		System.out.println("Hello World!");
		logger.info("main method ending");
	}

}
