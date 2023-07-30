package com.mycompany.javarushbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaRushTelegramBotApplication {

	public static void main(String[] args) {

		String properties = System.getenv("SPRING_PROFILES_ACTIVE");
		SpringApplication application = new SpringApplication(JavaRushTelegramBotApplication.class);

		if(properties != null)
			application.setAdditionalProfiles(properties);

		application.run(args);
	}

}
