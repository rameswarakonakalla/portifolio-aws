package com.cognizant.dailyshare;
/**
 * @author Ruksar, Revathi, Rameswara, Prachi
 *This is the main class
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class DailySharePriceApplication {

	public static void main(String[] args) {
		log.info("Start Application");
		SpringApplication.run(DailySharePriceApplication.class, args);
		log.info("End Application");
	}

}
