package com.cognizant.webservice.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *   model class for User Data 
 * @author Ruksar, Revathi, Rameswara, Prachi
 * 
 *        
 * 
 * @Data is a convenient shortcut annotation that bundles the features
 *       of @ToString , @EqualsAndHashCode , @Getter / @Setter
 *       and @RequiredArgsConstructor together
 *       
 *  @AllArgsConstructor It generates AllArgsConstructor
 *  
 *  @NoArgsConstructor It generates NolArgsConstructor
 *
 */ 
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

	/**
	 * Id for user
	 */

	private String userid;
	/**
	 * Password for user
	 */
	private String upassword;
	/**
	 * Name for user
	 */
	private String uname;
	/**
	 * Generated authentication token for the user
	 */
	private String authToken;

}
