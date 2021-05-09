package com.cognizant.calculateNetworth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.calculateNetworth.model.Asset;
/**
 * This is the repository layer for Asset class
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
public interface AssetRepository extends JpaRepository<Asset,Integer>{
	public List<Asset> findByPortfolioidOrderByAssetid(int id);
	
	public Asset findByPortfolioidAndAssetidAndType(int portfolioId,String assetId,String type);
}
