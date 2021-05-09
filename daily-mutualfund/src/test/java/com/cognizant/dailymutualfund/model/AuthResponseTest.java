package com.cognizant.dailymutualfund.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 * 
 * 		the class tests all the setters and getters and constructors
 * 		for the Authorization response 
 *
 */

class AuthResponseTest {
	AuthResponse authResponse=new AuthResponse();
	@Test
	void testGetUserId() {
		authResponse.setUserId("101");
		assertEquals("101", authResponse.getUserId());
	}
	@Test
	void testGetUserName() {
		authResponse.setUserName("Admin");
		assertEquals("Admin", authResponse.getUserName());
	}
	@Test
	void testIsValid() {
		authResponse.setValid(true);
		assertEquals(true, authResponse.isValid());
	}

	@Test
	void testToString() {
		AuthResponse authResponse1=new AuthResponse("101", "Admin",true);
		assertEquals("AuthResponse(userId=101, userName=Admin, isValid=true)",authResponse1.toString());
	}
}
