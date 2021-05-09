package com.cognizant.webservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.webservice.feignclient.CalculateNetworthFeignClient;
import com.cognizant.webservice.model.Asset;
import com.cognizant.webservice.model.SellObjectMap;
import com.cognizant.webservice.model.UserData;
import com.cognizant.webservice.service.WebportalService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 			@author Ruksar, Revathi, Rameswara, Prachi
 *
 * 		@RestController  a special controller used in RESTFul web services and 
 * 		the equivalent of @Controller and @ResponseBody
 * 		
 *		@Slf4j (Simple Logging Facade for Java) provides a simple abstraction of all
 *      the logging frameworks
 *      
 *      
 */
/**
 * 
 * This class is having all endpoints related to webcontroller
 *
 */
@RestController
@Slf4j
public class WebPortalController {

	/**
	 * This is a field of type UserData class which provides the utilities for the
	 * User details like UserId,UserName etc.
	 */
	@Autowired
	UserData admin;

	private static List<String> revokedTokens = new ArrayList<String>();

	/**
	 * This is a field of type WebportalService class which provides the service to
	 * the Controller class
	 */
	@Autowired
	WebportalService webportalService;

	/**
	 * 
	 * @param session Provides a way to identify a user across more than one page
	 *                request or visitto a Web site and to store information about
	 *                that user. This interface allows servlets to View and
	 *                manipulate information about a session, such as the
	 *                sessionidentifier, creation time, and last accessed time Bind
	 *                objects to sessions, allowing user information to persist
	 *                acrossmultiple user connections
	 * 
	 * @return Convenient constructor when there is no model data to expose.Can also
	 *         be used in conjunction with addObject. Ex : ModelAndView("Home");
	 * 
	 * 
	 */

	@GetMapping("/logout")
	public ModelAndView getLogout(HttpSession session) {
		if (session != null && (String) session.getAttribute("token") != null
				&& webportalService.isSessionValid((String) session.getAttribute("token"))) {
			revokedTokens.add((String) session.getAttribute("token"));
			return new ModelAndView("login");
		}
		return new ModelAndView("Home");
	}

	/**
	 * This method is used to check the login credentials, if there are valid, by
	 * checking against the database.
	 * 
	 * @param session Provides a way to identify a user across more than one page
	 *                request or visitto a Web site and to store information about
	 *                that user. This interface allows servlets to View and
	 *                manipulate information about a session, such as the
	 *                sessionidentifier, creation time, and last accessed time Bind
	 *                objects to sessions, allowing user information to persist
	 *                acrossmultiple user connections
	 * 
	 * @return Convenient constructor when there is no model data to expose.Can also
	 *         be used in conjunction with addObject. Ex : ModelAndView("Home");
	 * 
	 * 
	 */
	@GetMapping("/")
	public ModelAndView getLogin(HttpSession session) {
		log.info("Starting getLogin");
		if (session != null && (String) session.getAttribute("token") != null
				&& webportalService.isSessionValid((String) session.getAttribute("token"))
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending getLogin");
			return new ModelAndView("Home");
		}
		log.info("Ending getLogin");
		return new ModelAndView("login");
	}

	/**
	 * 
	 * 
	 * @param session Provides a way to identify a user across more than one page
	 *                request or visitto a Web site and to store information about
	 *                that user. This interface allows servlets to View and
	 *                manipulate information about a session, such as the
	 *                sessionidentifier, creation time, and last accessed time Bind
	 *                objects to sessions, allowing user information to persist
	 *                acrossmultiple user connections
	 * @param model
	 * 
	 *                Implementation of java.util.Map for use when building model
	 *                data for usewith UI tools. Supports chained calls and
	 *                generation of model attribute names.
	 * 
	 *                This class serves as generic model holder for Servlet MVC but
	 *                is not tied to it.Check out the Model interface for an
	 *                interface variant.
	 * 
	 * @param user    Model class for the business details
	 * 
	 * @return returns the constructor
	 */
	@PostMapping("/login")
	public <user> ModelAndView postLogin(HttpSession session, ModelMap model, @ModelAttribute UserData user,
			ModelMap warning) {
		log.info("Starting postLogin");
		log.info("Ending postLogin");
		return new ModelAndView(webportalService.postLogin(user, session, warning));
	}

	/**
	 * This method return the Home page
	 * 
	 * @param session Provides a way to identify a user across more than one page
	 *                request or visitto a Web site and to store information about
	 *                that user. This interface allows servlets to View and
	 *                manipulate information about a session, such as the
	 *                sessionidentifier, creation time, and last accessed time Bind
	 *                objects to sessions, allowing user information to persist
	 *                acrossmultiple user connections
	 * @return returns the constructor
	 */
	@GetMapping("/Home")
	public ModelAndView getHomePage(HttpSession session) {
		log.info("Starting getHomePage");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending getHomePage");
			return new ModelAndView("Home");
		}
		log.info("Ending getHomePage");
		return new ModelAndView("login");
	}

	@Autowired
	private CalculateNetworthFeignClient networthFeignClient;

	/**
	 * This method return the viewMutualFunds
	 * 
	 * @param session Provides a way to identify a user across more than one page
	 *                request or visitto a Web site and to store information about
	 *                that user. This interface allows servlets to View and
	 *                manipulate information about a session, such as the
	 *                sessionidentifier, creation time, and last accessed time Bind
	 *                objects to sessions, allowing user information to persist
	 *                acrossmultiple user connections
	 * @param model
	 * 
	 *                Implementation of java.util.Map for use when building model
	 *                data for usewith UI tools. Supports chained calls and
	 *                generation of model attribute names.
	 * 
	 *                This class serves as generic model holder for Servlet MVC but
	 *                is not tied to it.Check out the Model interface for an
	 *                interface variant.
	 * @return returns the constructor
	 */
	@GetMapping("/viewfunds")
	public ModelAndView showViewFunds(HttpSession session, ModelMap model) {
		log.info("Starting showViewFunds");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending showViewFunds");
			String s = (String) session.getAttribute("memberId");
			int i = Integer.parseInt(s);
			String token = (String) session.getAttribute("token");
			List<Asset> asset = networthFeignClient.getAllAssets(token, i);
			model.put("asset", asset);
			return new ModelAndView("viewfunds");
		}
		log.info("Ending viewMutualFunds");
		return new ModelAndView("login");
	}

	/**
	 * This method return the viewshares
	 * 
	 * @param session Provides a way to identify a user across more than one page
	 *                request or visitto a Web site and to store information about
	 *                that user. This interface allows servlets to View and
	 *                manipulate information about a session, such as the
	 *                sessionidentifier, creation time, and last accessed time Bind
	 *                objects to sessions, allowing user information to persist
	 *                acrossmultiple user connections
	 * @param model
	 * 
	 *                Implementation of java.util.Map for use when building model
	 *                data for usewith UI tools. Supports chained calls and
	 *                generation of model attribute names.
	 * 
	 *                This class serves as generic model holder for Servlet MVC but
	 *                is not tied to it.Check out the Model interface for an
	 *                interface variant.
	 * @return returns the constructor
	 */
	@GetMapping("/viewshares")
	public ModelAndView showViewShares(HttpSession session, ModelMap model) {
		log.info("Starting showViewShares");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending showViewShares");
			String s = (String) session.getAttribute("memberId");
			int i = Integer.parseInt(s);
			String token = (String) session.getAttribute("token");
			List<Asset> asset = networthFeignClient.getAllAssets(token, i);
			model.put("asset", asset);
			return new ModelAndView("viewshares");
		}
		log.info("Ending showViewShares");
		return new ModelAndView("login");
	}

	/**
	 * This method return the sellAssets
	 * 
	 * @param Provides a way to identify a user across more than one page request or
	 *                 visitto a Web site and to store information about that user.
	 *                 This interface allows servlets to View and manipulate
	 *                 information about a session, such as the sessionidentifier,
	 *                 creation time, and last accessed time Bind objects to
	 *                 sessions, allowing user information to persist acrossmultiple
	 *                 user connections
	 * @param model
	 * 
	 *                 Implementation of java.util.Map for use when building model
	 *                 data for usewith UI tools. Supports chained calls and
	 *                 generation of model attribute names.
	 * 
	 *                 This class serves as generic model holder for Servlet MVC but
	 *                 is not tied to it.Check out the Model interface for an
	 *                 interface variant.
	 * @return returns the constructor
	 */
	@GetMapping("/sellAssets")
	public ModelAndView showSupplyPage(HttpSession session, ModelMap model) {
		log.info("Starting showSellAssets");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending showSellAssets");
			String s = (String) session.getAttribute("memberId");
			int i = Integer.parseInt(s);
			String token = (String) session.getAttribute("token");
			List<Asset> asset = networthFeignClient.getAllAssets(token, i);
			model.put("asset", asset);
			return new ModelAndView("sellAssets");
		}
		log.info("Ending showSellAssets");
		return new ModelAndView("login");
	}

	/**
	 * This method return the viewportfolio
	 * 
	 * @param session Provides a way to identify a user across more than one page
	 *                request or visitto a Web site and to store information about
	 *                that user. This interface allows servlets to View and
	 *                manipulate information about a session, such as the
	 *                sessionidentifier, creation time, and last accessed time Bind
	 *                objects to sessions, allowing user information to persist
	 *                acrossmultiple user connections
	 * @param model
	 * 
	 *                Implementation of java.util.Map for use when building model
	 *                data for usewith UI tools. Supports chained calls and
	 *                generation of model attribute names.
	 * 
	 *                This class serves as generic model holder for Servlet MVC but
	 *                is not tied to it.Check out the Model interface for an
	 *                interface variant.
	 * @return returns the constructor
	 */
	@GetMapping("/viewportfolio")
	public ModelAndView showSupplyPages(HttpSession session, ModelMap model) {
		log.info("Starting showviewportfolio");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending showviewportfolio");
			String s = (String) session.getAttribute("memberId");
			int i = Integer.parseInt(s);
			String token = (String) session.getAttribute("token");
			List<Asset> asset = networthFeignClient.getAllAssets(token, i);
			model.put("asset", asset);
			return new ModelAndView("viewportfolio");
		}
		log.info("Ending showviewportfolio");
		return new ModelAndView("login");
	}

	/**
	 * This method return the viewNetworth
	 * 
	 * @param session Provides a way to identify a user across more than one page
	 *                request or visitto a Web site and to store information about
	 *                that user. This interface allows servlets to View and
	 *                manipulate information about a session, such as the
	 *                sessionidentifier, creation time, and last accessed time Bind
	 *                objects to sessions, allowing user information to persist
	 *                acrossmultiple user connections
	 * @param model
	 * 
	 *                Implementation of java.util.Map for use when building model
	 *                data for usewith UI tools. Supports chained calls and
	 *                generation of model attribute names.
	 * 
	 *                This class serves as generic model holder for Servlet MVC but
	 *                is not tied to it.Check out the Model interface for an
	 *                interface variant.
	 * @return returns the constructor
	 */
	@GetMapping("/viewNetworth")
	public ModelAndView showNetworth(HttpSession session, ModelMap model) {
		log.info("Starting viewNetworth");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending viewNetworth");
			String s = (String) session.getAttribute("memberId");
			int i = Integer.parseInt(s);
			String token = (String) session.getAttribute("token");
			model.put("networth", networthFeignClient.calculateNetworth(token, i));
			return new ModelAndView("viewNetworth");
		}
		log.info("Ending viewNetworth");
		return new ModelAndView("login");
	}

	/**
	 * This method return the viewNetworth
	 * 
	 * @param session Provides a way to identify a user across more than one page
	 *                request or visitto a Web site and to store information about
	 *                that user. This interface allows servlets to View and
	 *                manipulate information about a session, such as the
	 *                sessionidentifier, creation time, and last accessed time Bind
	 *                objects to sessions, allowing user information to persist
	 *                acrossmultiple user connections
	 * @param name    RequestParam(value="quantity")
	 * @param count   RequestParam(value="quantity")
	 * @param model   Implementation of java.util.Map for use when building model
	 *                data for usewith UI tools. Supports chained calls and
	 *                generation of model attribute names.
	 * 
	 *                This class serves as generic model holder for Servlet MVC but
	 *                is not tied to it.Check out the Model interface for an
	 *                interface variant.
	 * @return returns the constructor
	 */
	@PostMapping("/sellAssetsSelected")
	public <user> ModelAndView sellAssetsSelected(HttpSession session, @RequestParam("selected") String[] name,
			@RequestParam("quantity") String[] count, ModelMap model) {
		log.info("Starting sellAssetsSelected");
		log.info("Ending sellAssetsSelected");
		String s = (String) session.getAttribute("memberId");
		int i = Integer.parseInt(s);
		String token = (String) session.getAttribute("token");
		List<Asset> list = networthFeignClient.getAllAssets(token, i);
		SellObjectMap sell = webportalService.sellShares(list, i, name, count);
		Map<String, String> assetMap = webportalService.convertToMap(name, count);
		// log.info(map.toString());
		model.put("networth", networthFeignClient.calculateBalancePostSellPerStock(token, sell));
		model.addAttribute("assetMap", assetMap);
		return new ModelAndView("sellAssetsSelected");
	}

	

}
