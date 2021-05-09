package com.cognizant.auth.model;

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
 *         model class for user details
 * 
 * @Entity indicates Spring Data JPA that it is an entity class for the
 *         application
 * @Data is a convenient shortcut annotation that bundles the features
 *       of @ToString , @EqualsAndHashCode , @Getter / @Setter
 *       and @RequiredArgsConstructor together
 *
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userdata")
public class UserData {

	/**
	 * instance variables
	 * 
	 * @Id helps in defining the primary key
	 */

	@Id
	@Column(name = "userId")
	private String userid;

	@Column(name = "userPassword")
	private String upassword;

	@Column(name = "userName")
	private String uname;

	private String authToken;

}
