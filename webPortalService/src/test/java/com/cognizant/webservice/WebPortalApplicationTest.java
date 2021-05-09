package com.cognizant.webservice;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.webservice.controller.WebPortalController;
/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 * 
 * 		 With the @SpringBootTest annotation, Spring Boot provides a 
 * 		 convenient way to start up an application context to be used in a test
 *
 */
//@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class WebPortalApplicationTest {

	@Autowired
    private WebPortalController controller;

    @Autowired
    private MockMvc mvc;
    
    @Test
    void contextLoads() {
        assertNotNull(controller);
    }
    
    @Test
    public void testGetLogout() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/logout"))
         .andExpect(status().isOk());

    }
    
    @Test
    public void testGetLogin() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/"))
         .andExpect(status().isOk());

    }
    
    @Test
    public void testPostLogin() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .post("/login"))
         .andExpect(status().isOk());

    }
    
    
    @Test
    public void testGetHomePage() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/Home"))
         .andExpect(status().isOk());

    }
    
    @Test
    public void testshowSupplyPage() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/sellAssets"))
         .andExpect(status().isOk());

    }
    @Test
    public void testshowSupplyPages() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/viewportfolio"))
        .andExpect(status().isOk());

    }
    @Test
    public void testshowNetworth() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/viewNetworth"))
         .andExpect(status().isOk());

    }
    @Test
    public void testsellAssetsSelected() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/viewNetworth"))
         .andExpect(status().isOk());

    }
    
    
}
