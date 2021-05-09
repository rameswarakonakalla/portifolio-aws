package com.cognizant.auth.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 * 
 * @Configuration indicates that a class declares one or more @Bean methods and
 *                may be processed by the Spring container to generate bean
 *                definitions and service requests for those beans at runtime
 * 
 * @EnableSwagger2 indicates that Swagger support should be enabled. This should
 *                 be applied to a Spring java config and should have an
 *                 accompanying '@Configuration' annotation. Loads all required
 *                 beans defined in SpringSwaggerConfig
 * 
 * @EnableAutoConfiguration attempts to guess and configure beans that we are
 *                          likely to need.
 *
 */

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerUIController {

	/**
	 * Docket is a builder which is intended to be the primary interface into the
	 * Springfox framework. Provides sensible defaults and convenience methods for
	 * configuration.
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
}