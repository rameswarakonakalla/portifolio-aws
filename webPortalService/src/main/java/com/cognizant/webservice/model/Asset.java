package com.cognizant.webservice.model;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 * 
 *         model class for Asset
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
@Component
public class Asset {
	
	
	private int tid;
	
	private String assetid;
	
	private int portfolioid;
	
	private String type;
	
	private int units;

	
	
	
	
	
	
}
