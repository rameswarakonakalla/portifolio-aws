package com.cognizant.dailyshare.controller;

/**
 * @author Ruksar, Revathi, Rameswara, Prachi
 */
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.dailyshare.model.AuthResponse;


/**
 * This interface communicates with authorization service to verify the token.
 * It takes the url of the service to which it wants to communicate and the name
 * attribute in annotation FeignClient must be the name we have specified in the
 * properties file.
 * 
 */

@FeignClient(name = "authorization-service", url = "${feign.auth}")
public interface AuthClient {
	/**
	 * This method will verify whether the token is valid or expired.
	 * 
	 * @param token
	 * @return An object of type AuthResponse which has fields userid, username and
	 *         isValid.
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public AuthResponse getValidity(@RequestHeader("Authorization") String token);

}
