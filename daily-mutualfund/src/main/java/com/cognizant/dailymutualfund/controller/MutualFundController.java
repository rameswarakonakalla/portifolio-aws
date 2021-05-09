package com.cognizant.dailymutualfund.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dailymutualfund.exception.MutualFundNotFoundException;
import com.cognizant.dailymutualfund.model.MutualFund;
import com.cognizant.dailymutualfund.service.MutualFundService;

import lombok.extern.slf4j.Slf4j;

/**
 * This is the controller layer
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
@RestController
@Slf4j
public class MutualFundController {

	@Autowired
	private MutualFundService service;

	/**
	 * This method is used to get the details of all mutual fund only after
	 * authorizing the user
	 * 
	 * @param token
	 * @return List of Mutual Fund objects
	 */

	@GetMapping("/MutualFunds-Information")
	public List<MutualFund> getAllMutualFunds(@RequestHeader("Authorization") String token) {
		log.info("START :: Method :: getAllMutualFund() ::");
		if (service.isSessionValid(token)) {
			log.debug("Started fetching all mutual funds after authorization");
			return service.getAllMutualFunds();
		}
		return Collections.emptyList();

	}

	/**
	 * This method is used to get mutual fund details using name
	 * 
	 * @param token
	 * @param mutualFundName
	 * @return MutualFund object
	 * @throws MutualFundNotFoundException
	 */
	@GetMapping("/MutualFundByName/{mutualFundName}")
	public MutualFund getMutualFundByName(@RequestHeader("Authorization") String token,
			@PathVariable String mutualFundName) throws MutualFundNotFoundException {
		log.info("In getDailyMutualFundNavById Controller");
		if (service.isSessionValid(token)) {
			return service.getMutualFundByName(mutualFundName);
		}
		return null;
	}

	/**
	 * This method is used to get mutual fund details using id
	 * 
	 * @param token
	 * @param mutualFundId
	 * @return MutualFund object
	 * @throws MutualFundNotFoundException
	 */
	@GetMapping("/MutualFundById/{mutualFundId}")
	public MutualFund getMutualFundById(@RequestHeader("Authorization") String token,
			@PathVariable(value = "mutualFundId") String mutualFundId) throws MutualFundNotFoundException {

		log.info("In getDailyMutualFundNavById Controller");
		if (service.isSessionValid(token)) {
			return service.getMutualFundById(mutualFundId);
		}
		return null;
	}

	@GetMapping("/MutualFundByIdList/{mutualFundId}")
	public List<Double> getMutualFundByIdList(@RequestHeader("Authorization") String token,
			@PathVariable(value = "mutualFundId") List<String> mutualFundIdList) throws MutualFundNotFoundException {
		if (service.isSessionValid(token)) {
			return service.getMutualFundByIdList(mutualFundIdList);
		}
		return null;
	}
}
