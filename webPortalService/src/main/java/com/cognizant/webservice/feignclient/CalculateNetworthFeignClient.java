package com.cognizant.webservice.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.webservice.model.Asset;
import com.cognizant.webservice.model.SellObjectMap;


/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */

@FeignClient(name = "CalculateNetWorthService", url = "cde20ij012pod4auth-lb-1489670954.us-east-2.elb.amazonaws.com/netWorth")

public interface CalculateNetworthFeignClient {
	
	/**
	 * 
	 * @param token RequestHeader(value="Authorization")
	 * @param id  RequestHeader(value="Authorization")
	 * 
	 */
	@GetMapping("/NetWorth/calculateNetworth/{id}")
	public double calculateNetworth(@RequestHeader("Authorization") String token,@PathVariable(value="id") int id);
	
	/**
	 * 
	 * @param token RequestHeader(value="Authorization")
	 * @param id  RequestHeader(value="Authorization")
	 * 
	 */
	@GetMapping("/NetWorth/GetAllAssets/{id}")
	public List<Asset> getAllAssets(@RequestHeader("Authorization") String token,@PathVariable(value="id") int id);
	/**
	 * 
	 * @param token RequestHeader(value="Authorization")
	 * 
	 */
	@PostMapping("/NetWorth/SellAssets")
	public double calculateBalancePostSellPerStock(@RequestHeader("Authorization") String token,@RequestBody SellObjectMap sell);
	
}
