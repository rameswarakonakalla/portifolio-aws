package com.cognizant.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ruksar, Revathi, Rameswara, Prachi
 * @SpringBootApplication is used in our application or main class to enable a
 *                        host of features, e.g. Java-based Spring
 *                        configuration, component scanning, and in particular
 *                        for enabling Spring Boot's auto-configuration feature.
 */

@SpringBootApplication
public class AuthorizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}

}