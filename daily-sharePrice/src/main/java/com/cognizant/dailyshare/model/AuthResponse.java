package com.cognizant.dailyshare.model;
/**
 * 
 * This is a model class for authenticating response 
 * @author Ruksar, Revathi, Rameswara, Prachi
 *
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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