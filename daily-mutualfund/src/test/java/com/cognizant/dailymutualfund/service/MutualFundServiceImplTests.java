package com.cognizant.dailymutualfund.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.dailymutualfund.controller.AuthClient;
import com.cognizant.dailymutualfund.model.AuthResponse;
import com.cognizant.dailymutualfund.model.MutualFund;
import com.cognizant.dailymutualfund.repository.MutualFundRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class MutualFundServiceImplTests {

	@Autowired
	private MutualFundServiceImpl serviceImpl;
	@MockBean
	AuthClient authClient;
	@MockBean
	private MutualFundRepository repository;

	/**
	 * This method is used to test the serviceImpl getMutualFundbyName method
	 */

	MutualFund mutualFund1, mutualFund2, mutualFund3, mutualFund4;

	List<MutualFund> mutualFundList = new ArrayList<>();

	@BeforeEach
	void setUp() {
		mutualFund1 = new MutualFund("Axis", "Axis Bluechip fund", 9800.0);
		mutualFund2 = new MutualFund("Axis", "A Bluechip fund", 9800.0);
		mutualFund3 = new MutualFund("DSP", "DSP Midcap Fund", 6000.0);
		mutualFund4 = new MutualFund("SBI", "SBI Small Cap Fund", 4300.0);
		mutualFundList.add(mutualFund1);
		mutualFundList.add(mutualFund3);
		mutualFundList.add(mutualFund4);
	}

	@Test
	public void testGetMutualFundbyName() {

		Mockito.when(repository.findByMutualFundName("Axis Bluechip fund")).thenReturn(mutualFund1);
		assertThat(serviceImpl.getMutualFundByName("Axis Bluechip fund")).isEqualTo(mutualFund1);

	}

	/**
	 * This method is used to negatively test the serviceImpl getMutualFundbyName
	 * method
	 */
	@Test
	public void testGetMutualFundbyNameNegative() {

		Mockito.when(repository.findByMutualFundName("A Bluechip fund")).thenReturn(mutualFund2);
		assertThat(serviceImpl.getMutualFundByName("Axis Bluechip fund")).isNotEqualTo(mutualFund2);
	}

	/**
	 * This method is used to test the serviceImpl getMutualFundbyId method
	 */
	@Test
	public void testGetMutualFundbyId() {

		Mockito.when(repository.findByMutualFundId("AXIS")).thenReturn(mutualFund1);
		assertThat(serviceImpl.getMutualFundById("AXIS")).isEqualTo(mutualFund1);

	}

	/**
	 * This method is used to test the serviceImpl getAllMutualFund method
	 */
	@Test
	public void testGetAllMutalFunds() {
		Mockito.when(repository.findAll()).thenReturn(mutualFundList);
		assertThat(serviceImpl.getAllMutualFunds()).isEqualTo(mutualFundList);
	}

	@Test
	void isSessionValid() {
		when(authClient.getValidity("token")).thenReturn(new AuthResponse("101", "pwd", true));
		assertEquals(true, serviceImpl.isSessionValid("token"));
	}

}
