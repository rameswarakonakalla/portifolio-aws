package com.cognizant.dailyshare.controller;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.cognizant.dailyshare.model.AuthResponse;
import com.cognizant.dailyshare.model.ShareDetails;
import com.cognizant.dailyshare.service.ShareDetailsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ShareDetailsController.class)
class ShareDetailsControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ShareDetailsServiceImpl serviceImpl;
	
	@MockBean
    AuthClient authClient;
	
	
	@Test
	public void testGetAllDailySharePrice() throws Exception 
	{
		List<ShareDetails> shareDetailsList=new ArrayList<>();
		shareDetailsList.add(new ShareDetails("AMZ","Amazon",2500.0));
		shareDetailsList.add(new ShareDetails("GGL","Google",2000.0));
		AuthResponse response1 = new AuthResponse("uid", "uname", true);
        when(authClient.getValidity("token")).thenReturn(response1);
		when(serviceImpl.getAllShares()).thenReturn(shareDetailsList);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/getAllShares")
				.content(this.mapToJson(shareDetailsList))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).header("Authorization", "token")
				).andExpect(status().isOk());
	}
	
	
	@Test
	public void testGetDailySharePriceByName() throws Exception 
	{
		ShareDetails shareDetail=new ShareDetails("AMZ","Amazon",2500.0);
		AuthResponse response1 = new AuthResponse("uid", "uname", true);
        when(authClient.getValidity("token")).thenReturn(response1);
		when(serviceImpl.getShareByShareName("Amazon")).thenReturn(shareDetail);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/getShare/shareName/Amazon").content(this.mapToJson(shareDetail))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "token")
				).andExpect(status().isOk());
		
	}
	
	
	
	@Test
	public void testGetDailySharePriceById() throws Exception 
	{
		ShareDetails shareDetail=new ShareDetails("AMZ","Amazon",2500.0);
		AuthResponse response1 = new AuthResponse("uid", "uname", true);
        when(authClient.getValidity("token")).thenReturn(response1);
		when(serviceImpl.getShareByShareId("AMZ")).thenReturn(shareDetail);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/getShare/shareId/AMZ").content(this.mapToJson(shareDetail))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "token")
				).andExpect(status().isOk());
	}
	
	
	@Test
	public void testGetShareValuesByShareIdList() throws Exception 
	{
		List<String> shareIdList=new ArrayList<>();
		shareIdList.add("AMZ");
		shareIdList.add("GGL");
		List<Double> shareValueList=new ArrayList<>();
		shareValueList.add(2000.0);
		shareValueList.add(2500.0);
		AuthResponse response1 = new AuthResponse("uid", "uname", true);
        when(authClient.getValidity("token")).thenReturn(response1);
		when(serviceImpl.getShareValuesByShareIdList(shareIdList)).thenReturn(shareValueList);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/getShareValuesByShareIdList/shareIdList/AMZ,GGL").content(this.mapToJson(shareValueList))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "token")
				).andExpect(status().isOk());
		
	}
	
	private String mapToJson(Object object) throws JsonProcessingException{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
}

	
