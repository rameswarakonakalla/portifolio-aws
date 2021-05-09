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
public class AuthResponseTest {

	AuthResponse authResponse=new AuthResponse();
	@Test
	public void test() {
		new AuthResponse();
	}
	
	@Test
	public void testsetUid() {
		authResponse.setUid("101");
		assertEquals("101",authResponse.getUid() );
	}
	@Test
	public void testsetName() {
		authResponse.setName("user");
		assertEquals("user",authResponse.getName() );
	}
	@Test
	public void testsetisValild() {
		authResponse.setValid(true);
		assertEquals(true,authResponse.isValid() );
	}
	
	@Test
	public void testtoString() {
		String string = authResponse.toString();
		assertEquals(string,authResponse.toString() );
	}
	@Test
	public void testcanEqual() {
		AuthResponse auth=new AuthResponse();
		auth.canEqual(auth);
		
	}
	@Test
	public void testEqualsAndHashCode() {
		int hashCode = authResponse.hashCode();
		assertEquals(hashCode,authResponse.hashCode());
	}
	@Test
	public void testAllArgsConstructor() {
		AuthResponse authResponse2 = new AuthResponse("101", "user", true);
		assertEquals("101",authResponse2.getUid() );
		assertEquals("user",authResponse2.getName() );
		assertEquals(true,authResponse2.isValid() );
	}
}
