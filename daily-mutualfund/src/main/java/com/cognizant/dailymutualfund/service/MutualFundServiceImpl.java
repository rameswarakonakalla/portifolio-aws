package com.cognizant.dailymutualfund.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dailymutualfund.controller.AuthClient;
import com.cognizant.dailymutualfund.exception.MutualFundNotFoundException;
import com.cognizant.dailymutualfund.model.AuthResponse;
import com.cognizant.dailymutualfund.model.MutualFund;
import com.cognizant.dailymutualfund.repository.MutualFundRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * This is the service implementation layer
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
@Service
@Slf4j
public class MutualFundServiceImpl implements MutualFundService {

	@Autowired
	private MutualFundRepository repository;

	@Autowired
	private AuthClient authClient;

	/**
	 * This method is used to get the details of all mutual fund only after
	 * authorizing the user
	 * 
	 * @return List of MutualFund details
	 */
	@Transactional
	public List<MutualFund> getAllMutualFunds() {
		log.info("In getAllMutualFund Service");
		log.debug("MutualFund:{}", repository.findAll());
		log.info("End of getAllMutualFund Service");
		return repository.findAll();
	}

	/**
	 * This method is used to get mutual fund details using name
	 * 
	 * @param mutualFundName
	 * @throws MutualFundNotFoundException
	 * @return MutualFund object
	 */
	@Transactional
	public MutualFund getMutualFundByName(String mutualFundName) {
		log.info("In getMutualFundByName Service");
		log.debug("MutualFundByName:{}", repository.findByMutualFundName(mutualFundName));
		log.info("End of getMutualFundByName Service");
		return repository.findByMutualFundName(mutualFundName);
	}

	/**
	 * This method is used to get mutual fund details using id
	 * 
	 * @param mutualFundId
	 * @return MutualFund object
	 */
	public MutualFund getMutualFundById(String mutualFundId) {
		log.info("In getMutualFundById Service");
		log.debug("MutualFundById:{}", repository.findByMutualFundId(mutualFundId));
		log.info("End of getMutualFundById Service");
		return repository.findByMutualFundId(mutualFundId);
	}

	public List<Double> getMutualFundByIdList(List<String> mutualFundIdList) {
		List<Double> mfValueList = new ArrayList<>();
		List<MutualFund> mfList = repository.findByMutualFundId(mutualFundIdList);
		for (MutualFund m : mfList) {
			mfValueList.add(m.getMutualFundValue());
		}
		return mfValueList;
	}

	public Boolean isSessionValid(String token) {
		try {
			@SuppressWarnings("unused")
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
