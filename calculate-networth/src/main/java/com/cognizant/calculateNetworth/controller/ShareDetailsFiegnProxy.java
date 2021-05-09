package com.cognizant.calculateNetworth.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.calculateNetworth.model.StockDetails;

/**
 * Communication between ShareDetailsService and CalculateNetworth
 * microservices happens here using FeignClient
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
@FeignClient(name="ShareDetailsService",url="${fiegn.share}")

public interface ShareDetailsFiegnProxy {
	
	@GetMapping("/getAllShares")
	public List<StockDetails> getAllShares(@RequestHeader("Authorization") String token);
	
	@GetMapping("/getShare/shareName/{shareName}")
	public StockDetails getShareByShareName(@RequestHeader("Authorization") String token,@PathVariable(value="shareName") String shareName);
	
	@GetMapping("/getShareValuesByShareIdList/shareIdList/{shareId}")
	public List<Double> getShareValuesByShareIdList(@RequestHeader("Authorization") String token,@PathVariable(value="shareId")List<String> shareIdList);
	

}

