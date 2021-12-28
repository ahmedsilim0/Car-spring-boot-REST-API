package com.example.Yelo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//netstat -ano | findstr :8080
//taskkill /PID 12272 /F
//{
//    "name": "kia",
//    "color": "blue",
//    "model": "2012",
//    "owner": "ahmed",
//    "hideMe": false,
//}
@SpringBootApplication
public class YeloApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(YeloApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(YeloApplication.class, args);

		LOGGER.error("Message logged at ERROR level");
		LOGGER.warn("Message logged at WARN level");
		LOGGER.info("Message logged at INFO level");
		LOGGER.debug("Message logged at DEBUG level");
	}

}
