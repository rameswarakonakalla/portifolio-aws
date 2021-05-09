package com.cognizant.auth.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.auth.model.UserData;
import com.cognizant.auth.model.AuthResponse;
import com.cognizant.auth.repository.UserRepository;
import com.cognizant.auth.service.AdminDetailsService;
import com.cognizant.auth.service.JwtUtil;

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
public class AuthControllerTest {

	/**
	 * @InjectMocks annotation can be used to inject mock fields into a test object
	 *              automatically
	 */
	@InjectMocks
	AuthController authController;

	AuthResponse authResponse;

	UserDetails userdetails;

	@Mock
	JwtUtil jwtUtil;

	@Mock
	AdminDetailsService adminDetailService;

	@Mock
	UserRepository userservice;

	/**
	 * to test the login when valid details are entered
	 */
	@Test
	public void test_loginTest() {

		UserData user = new UserData("admin", "admin", null, null);
		UserDetails loadUserByUsername = adminDetailService.loadUserByUsername("admin");
		UserDetails userDetails = new User(user.getUserid(), user.getUpassword(), new ArrayList<>());
		when(adminDetailService.loadUserByUsername("admin")).thenReturn(userDetails);
		when(jwtUtil.generateToken(loadUserByUsername)).thenReturn("token");
		ResponseEntity<?> login = authController.login(user);
		assertEquals(200, login.getStatusCodeValue());
	}

	/**
	 * to test the login when invalid details are entered
	 */
	@Test
	public void test_loginTestFailed() {
		UserData user = new UserData("admin", "admin", null, null);
		UserDetails loadUserByUsername = adminDetailService.loadUserByUsername("admin");
		UserDetails userDetails = new User(user.getUserid(), "admin11", new ArrayList<>());
		when(adminDetailService.loadUserByUsername("admin")).thenReturn(userDetails);
		when(jwtUtil.generateToken(loadUserByUsername)).thenReturn("token");
		ResponseEntity<?> login = authController.login(user);
		assertEquals(login.getStatusCodeValue(), 403);
	}

	/**
	 * to test validation of valid token
	 */
	@Test
	public void test_validateTestValidtoken() {
		when(jwtUtil.validateToken("token")).thenReturn(true);
		when(jwtUtil.extractUsername("token")).thenReturn("admin");
		UserData user = new UserData("userId", "admin", "password", "authToken");
		Optional<UserData> data = Optional.of(user);
		when(userservice.findById("admin")).thenReturn(data);
		ResponseEntity<?> validity = authController.getValidity("bearer token");
		assertEquals(true, validity.getBody().toString().contains("true"));

	}

	/**
	 * to test validation of invalid token
	 */
	@Test
	public void test_validateTestInValidtoken() {
		when(jwtUtil.validateToken("token")).thenReturn(false);
		ResponseEntity<?> validity = authController.getValidity("bearer token");
		assertEquals(false, validity.getBody().toString().contains("true"));
	}

}
