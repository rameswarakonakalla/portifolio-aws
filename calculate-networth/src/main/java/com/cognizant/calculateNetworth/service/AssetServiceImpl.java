package com.cognizant.calculateNetworth.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.calculateNetworth.model.Asset;
import com.cognizant.calculateNetworth.repository.AssetRepository;

import lombok.extern.slf4j.Slf4j;
/**
 * This is the service implementation layer for Asset
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
@Service
@Slf4j
public class AssetServiceImpl implements AssetService{
	
	@Autowired
	private AssetRepository repository;
	
	/**
	 * This method is used to find portfolio using Asset id
	 * @param id
	 * @return List of Assets
	 */
	@Transactional
	public List<Asset> getAllAssetForPortfolio(int id){
		log.info("In Service getAllAssetForPortfolio");
		log.debug("Assets by Portfolio: {}",repository.findByPortfolioidOrderByAssetid(id));
		log.info("Ended Service getAllAssetForPortfolio");
		return repository.findByPortfolioidOrderByAssetid(id);
	}
	
	
 
}
