package com.cognizant.dailymutualfund.service;

import java.util.List;

import com.cognizant.dailymutualfund.exception.MutualFundNotFoundException;
import com.cognizant.dailymutualfund.model.MutualFund;
/**
 * This is the service layer interface
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
public interface MutualFundService {
	public List<MutualFund> getAllMutualFunds();
	public MutualFund getMutualFundByName(String mutualFundName) throws MutualFundNotFoundException;
	public List<Double> getMutualFundByIdList(List<String> mutualFundIdList) ;
	public MutualFund getMutualFundById(String mutualFundId);
	public Boolean isSessionValid(String token);

}
