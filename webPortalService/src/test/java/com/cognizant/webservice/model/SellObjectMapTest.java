package com.cognizant.webservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 * 
 * 
 *
 */
public class SellObjectMapTest {

	SellObjectMap sellObjectMap = new SellObjectMap();

	@Test
	public void testpId() {
		sellObjectMap.setPid(11);
		assertEquals(11, sellObjectMap.getPid());
	}

	@Test
	public void testSetStockIdList() {
		sellObjectMap.setStockIdList(null);
		assertEquals(null, sellObjectMap.getStockIdList());
	}

	@Test
	public void testSetMfAssetList() {
		sellObjectMap.setMfAssetList(null);
		assertEquals(null, sellObjectMap.getMfAssetList());
	}

	@Test
	public void testAllArgsConstructor() {
		SellObjectMap sellObjectMap1 = new SellObjectMap(0, null, null);
		assertEquals(0, sellObjectMap1.getPid());
		assertEquals(null, sellObjectMap1.getStockIdList());
		assertEquals(null, sellObjectMap1.getMfAssetList());
	}

	@Test
	public void testNoArgsConstructor() {
		new SellObjectMap();
	}
	@Test
	public void testcanEqual() {
		SellObjectMap sellObjectMap2 = new SellObjectMap();
				sellObjectMap2.canEqual(sellObjectMap2);
		
	}
	@Test
	public void testtoString() {
		String string = sellObjectMap.toString();
		assertEquals(string, sellObjectMap.toString());
	}
	@Test
	public void testEqualsAndHashCode() {
		int hashCode = sellObjectMap.hashCode();
		assertEquals(hashCode, sellObjectMap.hashCode());
	}
}
