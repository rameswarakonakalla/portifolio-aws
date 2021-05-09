package com.cognizant.webservice;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @author Ruksar, Revathi, Rameswara, Prachi
 * @SpringBootApplication is used in our application or main class to enable a
 *                        host of features, e.g. Java-based Spring
 *                        configuration, component scanning, and in particular
 *                        for enabling Spring Boot's auto-configuration feature.
 * @EnableFeignClients  Scans for interfaces that declare they are feign clients 
 * 						(via org.springframework.cloud.openfeign.FeignClient @FeignClient)
 * 						.Configures component scanning directives for use with 
 * 						org.springframework.context.annotation
 * 						.Configuration @Configuration classes.
 */
@SpringBootApplication
@EnableFeignClients
public class WebPortalApplication implements ServletContextInitializer{

	public static void main(String[] args) {
		SpringApplication.run(WebPortalApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.getSessionCookieConfig().setName("PmsSession");
	}

}
