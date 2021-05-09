package com.cognizant.calculateNetworth.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.calculateNetworth.model.Asset;
import com.cognizant.calculateNetworth.model.MutualFundDetails;
import com.cognizant.calculateNetworth.model.SellObjectMap;
import com.cognizant.calculateNetworth.model.StockDetails;
import com.cognizant.calculateNetworth.service.AssetServiceImpl;
import com.cognizant.calculateNetworth.service.SellAssetServiceImpl;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
@RestController
@RequestMapping("/NetWorth")
@Slf4j
public class StocksContoller {

	@Autowired
	private ShareDetailsFiegnProxy proxy;

	@Autowired
	private MutualFundDetailsFeignProxy mutualFundProxy;

	@Autowired
	private AssetServiceImpl assetservice;

	@Autowired
	private SellAssetServiceImpl sellService;

	/**
	 * This method calculates the net worth of the shares and mutual funds owned by the user
	 * @param token
	 * @param id
	 * @return Value of the assets owned by the user
	 */
	@GetMapping("/calculateNetworth/{id}")
	public double getAsset(@RequestHeader("Authorization") String token,@PathVariable(value = "id") int id) 
	{
		log.info("In service getAsset");
		double netWorth = 0.0;
		if(sellService.isSessionValid(token)) {
		List<String> stockAssetList = new ArrayList<>();
		List<String> mutualFundAssetList = new ArrayList<>();
		List<Double> stockValueList = new ArrayList<>();
		List<Double> mutualFundValueList = new ArrayList<>();
		List<Asset> assets = assetservice.getAllAssetForPortfolio(id);
		
		for (Asset a : assets) {
			if (a.getType().equals("Share")) {
				stockAssetList.add(a.getAssetid());
			} else {
				mutualFundAssetList.add(a.getAssetid());
			}
		}
		if (!stockAssetList.isEmpty()) {
			stockValueList = proxy.getShareValuesByShareIdList(token,stockAssetList);
		}
		if (!mutualFundAssetList.isEmpty()) {
			mutualFundValueList = mutualFundProxy.getMutualFundByIdList(token,mutualFundAssetList);
		}
		int stockCounter = 0;
		int mfCounter = 0;
		for (Asset a : assets) {
			if (a.getType().equals("Share")) {
				netWorth += a.getUnits() * stockValueList.get(stockCounter);
				stockCounter++;
			} else {
				netWorth += a.getUnits() * mutualFundValueList.get(mfCounter);
				mfCounter++;
			}
		}
		}
		return netWorth;

	}

	/**
	 * This method is used to calculate networth after selling assets
	 * @param token
	 * @param sell
	 * @return Value of the assets owned by the user after selling
	 */
	@PostMapping("/SellAssets")
	public double calculateBalancePostSellPerStock(@RequestHeader("Authorization") String token,@RequestBody SellObjectMap sell) {
		log.info("In service calculateBalancePostSell" );
		if(sellService.isSessionValid(token)) {
		Map<String, Integer> stockIdList = sell.getStockIdList();
		Map<String, Integer> mfIdList = sell.getMfAssetList();
		if (!stockIdList.isEmpty()) {
			sellService.deleteStockAssetWithUnits(sell.getPid(), stockIdList);
		}
		if (!mfIdList.isEmpty()) {
			sellService.deleteMutualFundAssetWithUnits(sell.getPid(), mfIdList);
		}
		}
		return getAsset(token,sell.getPid());
	}
 
	/**
	 * This method returns the assets owned by a particular user
	 * @param token
	 * @param portfolioId
	 * @return All the assets owned by the user
	 */
	@GetMapping("/GetAllAssets/{portfolioId}")
	public List<Asset> getAllAssets(@RequestHeader("Authorization") String token,@PathVariable(value = "portfolioId") int portfolioId) {
		log.info("In service getAllAssets");
		if(sellService.isSessionValid(token)) {
			return assetservice.getAllAssetForPortfolio(portfolioId);
		}
		return null;
	}


	
}