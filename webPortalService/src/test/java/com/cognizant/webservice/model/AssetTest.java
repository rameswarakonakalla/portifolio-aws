package com.cognizant.webservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;




public class AssetTest {
	
	
	Asset asset = new Asset();
	
	@Test
	public void testSetTid() {
		asset.setTid(1);
		assertEquals(1,asset.getTid());
	}
	@Test
	public void testGetTid() {
		int tid = asset.getTid();
		assertEquals(tid,asset.getTid());
	}

	@Test
	public void testSetAssetid() {
		asset.setAssetid("101");
		assertEquals("101",asset.getAssetid());
	}
	@Test
	public void testGetAssetid() {
		String assetid = asset.getAssetid();
		assertEquals(assetid,asset.getAssetid());
	}

	@Test
	public void testSetPortfolioid() {
		asset.setPortfolioid(11);
		assertEquals(11,asset.getPortfolioid());
	}
	@Test
	public void testGetPortfolioid() {
		int portfolioid = asset.getPortfolioid();
		assertEquals(portfolioid,asset.getPortfolioid());
	}

	@Test
	public void testSetType() {
		asset.setType("MF");
		assertEquals("MF",asset.getType());
	}
	
	@Test
	public void testGetType() {
		String type = asset.getType();
		assertEquals(type,asset.getType());
	}

	@Test
	public void testSetUnits() {
		asset.setUnits(10);
		assertEquals(10,asset.getUnits());
	}
	
	@Test
	public void testGetUnits() {
		
		assertEquals(asset.getUnits(),asset.getUnits());
	}
	
	@Test
	public void testAsset() {
		Asset asset1=new Asset();
		asset1.canEqual(asset1);
		
	}
	
	

	@Test
	public void testAllArgsConstructor() {
		Asset asset2 = new Asset(1, "101", 11, "MF", 10);
		assertEquals(1, asset2.getTid());
		assertEquals("101", asset2.getAssetid());
		assertEquals(11, asset2.getPortfolioid());
		assertEquals("MF", asset2.getType());
		assertEquals(10, asset2.getUnits());
	}
	
	@Test
	public void testNoArugs() {
		new Asset();
	}
	
	@Test
	public void testtoString() {
		
		String string = asset.toString();
		assertEquals(string, asset.toString());
	}
	@Test
	public void testEqualsAndHashCode() {
		
		 int hashCode = asset.hashCode();
		assertEquals(hashCode, asset.hashCode());
	}

	


}
