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
 *         Authorization response
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthResponseTest {

	AuthResponse authResponse = new AuthResponse();

	@Test
	public void testUid() {
		authResponse.setUid("1");
		assertEquals("1", authResponse.getUid());
	}

	@Test
	public void testName() {
		authResponse.setName("Admin");
		assertEquals("Admin", authResponse.getName());
	}

	@Test
	public void testIsValid() {
		authResponse.setValid(true);
		assertEquals(true, authResponse.isValid());
	}

	@Test
	public void testToString() {
		AuthResponse authrespo = new AuthResponse("1", "Admin", true);
		assertEquals("Admin", authrespo.getName());
	}
}
