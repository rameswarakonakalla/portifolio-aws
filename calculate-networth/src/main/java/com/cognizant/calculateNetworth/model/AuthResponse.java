package com.cognizant.calculateNetworth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

	private String uid;

	private String name;

	private boolean isValid;


}
