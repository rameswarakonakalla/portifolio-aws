package com.cognizant.webservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.webservice.model.AuthResponse;
import com.cognizant.webservice.model.UserData;

/**
 * @author Ruksar, Revathi, Rameswara, Prachi
 * @FeignClient 	Annotation for interfaces declaring that a REST client with that interface should be
 * 					created (e.g. for autowiring into another component). If SC LoadBalancer is available
 * 					it will be used to load balance the backend requests, and the load balancer can be
 * 					configured using the same name (i.e. value) as the feign client.
 */

@FeignClient(name = "authorization-service", url = "cde20ij012pod4auth-lb-1489670954.us-east-2.elb.amazonaws.com/auth")

public interface AuthClient {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserData login(@RequestBody UserData userlogincredentials);

	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public AuthResponse getValidity(@RequestHeader("Authorization") String token);

}
