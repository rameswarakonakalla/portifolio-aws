package com.cognizant.calculateNetworth.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.calculateNetworth.model.MutualFundDetails;
/**
 * Communication between DailyMutualFundService and CalculateNetworth
 *
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
@FeignClient(name="DailyMutualFundService",url="${fiegn.mutualfund}")

public interface MutualFundDetailsFeignProxy {
	
	@GetMapping("/MutualFunds-Information")
	public List<MutualFundDetails> getAllMutualFunds(@RequestHeader("Authorization") String token);
	
	@GetMapping("/MutualFundByName/{mutualFundName}")
	public MutualFundDetails getMutualFundByName(@RequestHeader("Authorization") String token,@PathVariable(value="mutualFundName") String mutualFundName);
	
	@GetMapping("/MutualFundByIdList/{mutualFundId}")
	public List<Double> getMutualFundByIdList(@RequestHeader("Authorization") String token,@PathVariable(value="mutualFundId") List<String> mutualFundId);

}
