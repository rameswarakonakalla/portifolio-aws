package com.cognizant.calculateNetworth.service;

import java.util.List;

import com.cognizant.calculateNetworth.model.Asset;
/**
 * This is the service interface layer for Asset
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
public interface AssetService {
	public List<Asset> getAllAssetForPortfolio(int id);

}
