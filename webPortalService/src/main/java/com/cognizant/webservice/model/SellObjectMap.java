package com.cognizant.webservice.model;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 * 
 *         model class for Sell Object Map
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
public class SellObjectMap {

	int pid;

	Map<String,Integer> stockIdList;

	Map<String,Integer> mfAssetList;
}
