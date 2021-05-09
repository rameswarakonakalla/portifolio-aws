package com.cognizant.calculateNetworth.model;

import java.util.Map;

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
public class SellObjectMap {

	int pid;

	Map<String, Integer> stockIdList;

	Map<String, Integer> mfAssetList;

}
