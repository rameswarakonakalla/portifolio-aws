package com.cognizant.calculateNetworth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
@SpringBootApplication
@EnableFeignClients
@Slf4j
public class CalculateNetworthApplication {

	public static void main(String[] args) {
		log.info("Started Main");
		SpringApplication.run(CalculateNetworthApplication.class, args);
		log.info("Ended Main");
	}

}
