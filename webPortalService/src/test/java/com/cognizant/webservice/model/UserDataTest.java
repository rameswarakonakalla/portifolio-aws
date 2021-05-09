package com.cognizant.webservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
/**
 * The class tests all the setters and getters and constructors
 * 		for the userdata details 
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 * 
 * 		
 *
 */
public class UserDataTest {
	
	UserData userData=new UserData();

	@Test
	void testSetUserid() {
		userData.setUserid("user1");
		assertEquals("user1", userData.getUserid());
	}

	@Test
	void testSetUpassword() {
		userData.setUpassword("pwd");
		assertEquals("pwd", userData.getUpassword());
	}

	@Test
	void testSetUname() {
		userData.setUname("user1");
		assertEquals("user1", userData.getUname());
	}

	@Test
	void testSetAuthToken() {
		userData.setAuthToken("authToken");
		assertEquals("authToken", userData.getAuthToken());
	}

	@Test
	void testAllArgsConstructor() {
		UserData userData1=new UserData("101", "pwd", "101", "usertoken");
		assertEquals("101", userData1.getUserid());
		assertEquals("pwd", userData1.getUpassword());
		assertEquals("101", userData1.getUname());
		assertEquals("usertoken", userData1.getAuthToken());
		
	}

	@Test
	void testNoArgsConstructor() {
		new UserData();
	}
	
	@Test
	public void testcanEqual() {
		UserData userData=new UserData();
		userData.canEqual(userData);
		
	}
	
	@Test
	public void testtoString() {
		
		String string = userData.toString();
		assertEquals(string, userData.toString());
	}
	@Test
	public void testEqualsAndHashCode() {
		
		 int hashCode = userData.hashCode();
		assertEquals(hashCode, userData.hashCode());
	}

}
