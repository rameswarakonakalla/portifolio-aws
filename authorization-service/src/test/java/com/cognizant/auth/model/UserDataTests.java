package com.cognizant.auth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 * 
 *         the class tests all the setters and getters and constructors for the
 *         userdata details
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDataTests {

	UserData user = new UserData();

	@Test
	public void testUserid() {
		user.setUserid("102");
		assertEquals("102", user.getUserid());
	}

	@Test
	public void testUserName() {
		user.setUname("102");
		assertEquals("102", user.getUname());
	}

	@Test
	public void testUserPassword() {
		user.setUpassword("admin1");
		assertEquals("admin1", user.getUpassword());
	}

	@Test
	public void testToString() {
		String string = user.toString();
		assertEquals(user.toString(), string);
	}

	@Test
	public void testAuthToken() {
		user.setAuthToken("token");
		assertEquals("token", user.getAuthToken());
	}

}
