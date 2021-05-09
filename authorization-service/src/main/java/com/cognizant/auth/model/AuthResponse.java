package com.cognizant.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

	private String uid;

	private String name;

	private boolean isValid;

}
