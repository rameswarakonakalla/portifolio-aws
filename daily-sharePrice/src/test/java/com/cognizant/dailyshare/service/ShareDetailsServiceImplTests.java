package com.cognizant.dailyshare.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import com.cognizant.dailyshare.controller.AuthClient;
import com.cognizant.dailyshare.model.AuthResponse;
import com.cognizant.dailyshare.model.ShareDetails;
import com.cognizant.dailyshare.respository.ShareRepository;
import java.util.ArrayList;
import java.util.List;
import org.mockito.Mockito;

/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ShareDetailsServiceImplTests {
	
	@Autowired
	private ShareDetailsServiceImpl serviceImpl;
	
	@MockBean
	AuthClient authClient;
	
	@MockBean
	private ShareRepository repository;
	
	ShareDetails shareDetail1,shareDetail2;
	
	List<ShareDetails> shareDetailsList=new ArrayList<>();
	
	@BeforeEach
	void setUp() {
		shareDetail1=new ShareDetails("AMZ","Amazon",2500.0);
		shareDetail2=new ShareDetails("GGL","Google",2000.0);
		shareDetailsList.add(shareDetail1);
		shareDetailsList.add(shareDetail2);
	}
	
	
	@Test
	public void testGetShareByShareName() {
		Mockito.when(repository.findByShareName("Amazon")).thenReturn(shareDetail1);
		assertThat(serviceImpl.getShareByShareName("Amazon")).isEqualTo(shareDetail1);
		
	}
	
	
	
	@Test
	public void testGetShareByShareId() {
		
		Mockito.when(repository.findByShareId("AMZ")).thenReturn(shareDetail1);
		assertThat(serviceImpl.getShareByShareId("AMZ")).isEqualTo(shareDetail1);
	}
	
	
	
	@Test
	public void testGetAllShares()
	{
		Mockito.when(repository.findAll()).thenReturn(shareDetailsList);
		assertThat(serviceImpl.getAllShares()).isEqualTo(shareDetailsList);
	}
	
	
	@Test
	public void testGetShareValuesByShareIdList() {
		List<String> shareIdList=new ArrayList<>();
		shareIdList.add("AMZ");
		shareIdList.add("GGL");
		List<Double> shareValueList=new ArrayList<>();
		shareValueList.add(2500.0);
		shareValueList.add(2000.0);
		Mockito.when(repository.findShareValuesListByShareId(shareIdList)).thenReturn(shareDetailsList);
		assertThat(serviceImpl.getShareValuesByShareIdList(shareIdList)).isEqualTo(shareValueList);
		
	}
	
	
	@Test
	void isSessionValid() {
		when(authClient.getValidity("token")).thenReturn(new AuthResponse("101", "admin", true));
		assertEquals(true,serviceImpl.isSessionValid("token"));
	}
	
	
	
}
