package com.cognizant.dailymutualfund.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.dailymutualfund.model.AuthResponse;
import com.cognizant.dailymutualfund.model.MutualFund;
import com.cognizant.dailymutualfund.service.MutualFundServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MutualFundController.class)
class MutualFundControllerTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	MutualFundServiceImpl serviceImpl;
	
	@MockBean
    AuthClient authClient;

	/**
	 * testing method that returns all mutual fund details
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetAllMutualFund() throws Exception {
		MutualFund mutualFund1 = new MutualFund("AXIS", "Axis Bluechip fund", 9800.0);
		MutualFund mutualFund2 = new MutualFund("DSP", "DSP Midcap Fund", 6000.0);
		MutualFund mutualFund3 = new MutualFund("SBI", "SBI Small Cap Fund", 4300.0);
		List<MutualFund> shareDetailsList = new ArrayList<>();
		shareDetailsList.add(mutualFund1);
		shareDetailsList.add(mutualFund2);
		shareDetailsList.add(mutualFund3);
		when(serviceImpl.getAllMutualFunds()).thenReturn(shareDetailsList);
		mockMvc.perform(MockMvcRequestBuilders.get("/MutualFunds-Information").content(this.mapToJson(shareDetailsList))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "token")).andExpect(status().isOk());

	}

	/**
	 * testing method that returns share by passing mutual fund name
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetMutualFundByName() throws Exception {

		MutualFund mutualFund = new MutualFund("AXIS", "Axis Bluechip fund", 9800.0);
		when(serviceImpl.getMutualFundByName("Axis Bluechip fund")).thenReturn(mutualFund);
		mockMvc.perform(MockMvcRequestBuilders.get("/MutualFundByName/Axis Bluechip fund")
				.content(this.mapToJson(mutualFund)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).header("Authorization", "token")).andExpect(status().isOk());
	}

	/**
	 * This method is for a negative testcase for getMutualFundByName method
	 * 
	 * @throws Exception
	 */

	@Test
	public void testGetMutualFundByNameNegative() throws Exception {
		MutualFund mutualFund = new MutualFund("HYD", "Hydra fund", 9800.0);
		when(serviceImpl.getMutualFundByName("Hydra Fund")).thenReturn(mutualFund);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/MutualFundByName/Hydra fund").content(this.mapToJson(mutualFund))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

	}

	/**
	 * testing method that returns share by passing mutual fund id
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetMutualFundById() throws Exception {

		MutualFund mutualFund = new MutualFund("AXIS", "Axis Bluechip fund", 9800.0);
		when(serviceImpl.getMutualFundById("AXIS")).thenReturn(mutualFund);
		mockMvc.perform(MockMvcRequestBuilders.get("/MutualFundById/AXIS").content(this.mapToJson(mutualFund))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "token")).andExpect(status().isOk());
	}

	/**
	 * This method is for a negative testcase for getMutualFundById method
	 * 
	 * @throws Exception
	 */

	@Test
	public void testGetMutualFundByIdNegative() throws Exception {
		MutualFund mutualFund = new MutualFund("HYD", "Hydra fund", 9800.0);
		when(serviceImpl.getMutualFundById("HYD")).thenReturn(mutualFund);
		mockMvc.perform(MockMvcRequestBuilders.get("/MutualFundById/HYD").content(this.mapToJson(mutualFund))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

	}
	
	@Test
	public void testGetMutualFundValueByMutualFundIdList() throws Exception 
	{
		List<String> mutualFundIdList=new ArrayList<>();
		mutualFundIdList.add("AXIS");
		mutualFundIdList.add("DSP");
		List<Double> mutualFundValueList=new ArrayList<>();
		mutualFundValueList.add(9800.0);
		mutualFundValueList.add(6000.0);
		AuthResponse response1 = new AuthResponse("uid", "uname", true);
        when(authClient.getValidity("token")).thenReturn(response1);
		when(serviceImpl.getMutualFundByIdList(mutualFundIdList)).thenReturn(mutualFundValueList);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/getMutualFundValueByMutualFundIdList/AXIS").content(this.mapToJson(mutualFundValueList))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "token")
				).andExpect(status().isNotFound());
		
	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);

	}

}