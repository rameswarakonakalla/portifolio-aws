package com.cognizant.webservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.cognizant.webservice.feignclient.AuthClient;
import com.cognizant.webservice.model.Asset;
import com.cognizant.webservice.model.SellObjectMap;
import com.cognizant.webservice.model.UserData;

/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */

@Service
public class WebportalService {
	
	
	@Autowired
	private AuthClient authClient;
	
	/**
	 * 
	 * @param user It holds the user details
	 * @param session  session Provides a way to identify a user across more than one page
	 *                request or visitto a Web site and to store information about
	 *                that user. This interface allows servlets to View and
	 *                manipulate information about a session, such as the
	 *                sessionidentifier, creation time, and last accessed time Bind
	 *                objects to sessions, allowing user information to persist
	 *                acrossmultiple user connections
	 * 
	 * 
	 */
	public String postLogin(UserData user, HttpSession session, ModelMap warning) {

		UserData res = null;
		try {
			res = authClient.login(user);
		} catch (Exception e) {
			String errmsg = "";
			if (e.getClass().toString().contains("feign.RetryableException"))
				errmsg = "Site is Temporarily down. Try again later.";
			else
				errmsg = "Unable to login. please check your credentials.";
			warning.addAttribute("errormsg", errmsg);
			return "login";
		}
		session.setAttribute("token", "Bearer " + res.getAuthToken());
		session.setAttribute("memberId", res.getUserid());
		return getHomePage((String) session.getAttribute("token"));
	}
	/**
	 * 
	 * @param token it accepts token as parameter
	 *
	 */
	public String getHomePage(String token) {

		try {
			authClient.getValidity(token);
		} catch (Exception e) {
			return "redirect:/";
		}
		return "Home";

	}
	/**
	 * 
	 * @param name it accepts name as parameter
	 * @param counts it accepts count as parameter
	 */
	public Map<String,String> convertToMap(String[] name,String[] counts){
		Map<String, String> map=new HashMap<String, String>();
		int v=0;
		String[] count=new String[name.length];
		for(int j=0;j<counts.length;j++) {
			if(!counts[j].equals("0")) {
				count[v++]=counts[j];
			}
			
		}
		for(int i=0;i<count.length;i++) {
			map.put(name[i], count[i]);
		}
		return map;
		
	}
	
	public SellObjectMap sellShares(List<Asset> list, int i,String[] name,String[] counts){
		
		Map<String, Integer> stockIdList=new HashMap<String, Integer>();
		Map<String, Integer> mfIdList=new HashMap<String, Integer>();
	
		int v=0;
		String[] count=new String[name.length];
		for(int j=0;j<counts.length;j++) {
			if(!counts[j].equals("0")) {
				count[v++]=counts[j];
			}
			
		}
		
		String type="";
		for(int j=0;j<name.length;j++)
		{
			for(int k=0;k<list.size();k++)
			{
				if(list.get(k).getAssetid().equals(name[j]))
				{
					type=list.get(k).getType();
				}
			}
			if(type.equals("Share"))
			{
				stockIdList.put(name[j], Integer.parseInt(count[j]));
				
			}
			else if(type.equals("MF"))
			{
				mfIdList.put(name[j], Integer.parseInt(count[j]));
			}
			
			/*
			 * try { if(type.equals("Share")) { stockIdList.put(name[j],
			 * Integer.parseInt(count[j]));
			 * 
			 * } else if(type.equals("MF")) { mfIdList.put(name[j],
			 * Integer.parseInt(count[j])); } } catch (Exception e) { // TODO: handle
			 * exception e.printStackTrace(); }
			 */
		}
		SellObjectMap sell=new SellObjectMap(i, stockIdList, mfIdList);
		return sell;
	} 
	
	/**
	 * 
	 * @param token  it accepts token as parameter
	 * @return returns a boolean value
	 */
	
	public Boolean isSessionValid(String token) {
		try {
			authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
