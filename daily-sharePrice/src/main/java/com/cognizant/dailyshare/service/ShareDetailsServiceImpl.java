package com.cognizant.dailyshare.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dailyshare.controller.AuthClient;

import com.cognizant.dailyshare.model.AuthResponse;
import com.cognizant.dailyshare.model.ShareDetails;
import com.cognizant.dailyshare.respository.ShareRepository;

/**
 * @author Ruksar, Revathi, Rameswara, Prachi
 * This is a sevice implementation class 
 */
@Service
public class ShareDetailsServiceImpl implements ShareDetailsService {
	
	
	@Autowired
	private ShareRepository repository;
	
	@Autowired
	private AuthClient authClient;
	
	/**
	 * method fetches and returns all shares
	 */
	@Transactional
	@Override
	public List<ShareDetails> getAllShares(){
		return repository.findAll();
	}
	
	/**
	 * method fetches and returns share with shareName that is passed
	 */
	@Transactional
	@Override
	public ShareDetails getShareByShareName(String shareName) {
		return repository.findByShareName(shareName);
	}
	
	/**
	 * method fetches and returns share with shareId that is passed
	 */
	@Transactional
	@Override
	public ShareDetails getShareByShareId(String shareId){
		return repository.findByShareId(shareId);
	}
	
	/**
	 * method fetches and returns all share values list
	 */
	@Override
	public List<Double> getShareValuesByShareIdList(List<String> shareIdList) {
		List<Double> shareValueList = new ArrayList<>();
		List<ShareDetails> shareList=  repository.findShareValuesListByShareId(shareIdList);
		for(ShareDetails s:shareList) {
			shareValueList.add( s.getShareValue());
		}
		return shareValueList;
	}
	
	/**
	 * method checks if user is authorized or not
	 */
	
	public Boolean isSessionValid(String token) {
		try {
			
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		} 
		return true;
	}
	

}
