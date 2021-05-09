package com.cognizant.calculateNetworth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
	
	@Id
	@Column
	private int tid;
	
	
	@Column
	private String assetid;
	@Column
	private int portfolioid;
	@Column
	private String type;
	@Column
	private int units;
	
	
}
