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
public class StockDetails {
	
	private String shareId;

	private String shareName;

	private double shareValue;

}
