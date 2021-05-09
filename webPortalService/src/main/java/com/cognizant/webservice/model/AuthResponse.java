package com.cognizant.webservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 * 
 *         model class for authorization response
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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
	private String uid;
	private String name;
	private boolean isValid;
}
