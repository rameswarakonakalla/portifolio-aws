package com.cognizant.dailyshare.service;

import java.util.List;

import com.cognizant.dailyshare.model.ShareDetails;
/**
 * @author Ruksar, Revathi, Rameswara, Prachi
 * This is a sevice interface 
 */
public interface ShareDetailsService {
	/**
	 * 
	 * @return all shares
	 */
	public List<ShareDetails> getAllShares();
	
	/**
	 * 
	 * @param shareName
	 * @return share with shareName that is passed
	 */
	public ShareDetails getShareByShareName(String shareName) ;
	
	/**
	 * 
	 * @param shareId
	 * @return share with shareId that is passed
	 */
	public ShareDetails getShareByShareId(String shareId);
	
	/**
	 * 
	 * @param shareId
	 * @return all share values list
	 */
	public List<Double> getShareValuesByShareIdList(List<String> shareIdList);
	
	/**
	 * 
	 * @param token
	 * @return true of false based on user is authorized or not
	 */
	 public Boolean isSessionValid(String token);
	
	
}
