package com.cognizant.auth.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.auth.repository.UserRepository;

import io.jsonwebtoken.Claims;

/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 * 
 *         With the @SpringBootTest annotation, Spring Boot provides a
 *         convenient way to start up an application context to be used in a
 *         test
 * @RunWith is an annotation to use test runners
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtUtilTest {

	UserDetails userDetails;

	/**
	 * @InjectMocks annotation can be used to inject mock fields into a test object
	 *              automatically
	 */
	@InjectMocks
	JwtUtil jwtUtil;

	@Mock
	UserRepository userRepository;

	@Mock
	Claims claim;

	/**
	 * to test the generation of a token
	 */
	@Test
	public void test_generateTokenTest() {
		userDetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		assertNotNull(generateToken);
	}

	/**
	 * to test the validateToken()
	 */
	@Test
	public void test_validateTokenTest() {
		userDetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}

	/**
	 * to test the validate token by name
	 */
	@Test
	public void test_validateTokenWithNameTest() {
		userDetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken, userDetails);
		assertEquals(true, validateToken);
	}

}
