package com.cognizant.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.cognizant.auth.service.AdminDetailsService;

/**
 * 
 * @author Ruksar, Revathi, Rameswara, Prachi
 * 
 * @EnableWebSecurity is used for Spring Security configuration defined in any
 *                    WebSecurityConfigurer or more likely by extending the
 *                    WebSecurityConfigurerAdapter base class and overriding
 *                    individual methods
 *
 */

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfigurer.class);

	/**
	 * autowired the pmsuserDetailsService
	 */
	@Autowired
	AdminDetailsService pmsuserDetailsService;

	/**
	 * to attempt to obtain an AuthenticationManager.
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		LOGGER.info("START");
		super.configure(auth);
		auth.userDetailsService(pmsuserDetailsService);
		LOGGER.info("END");

	}

	/**
	 * to configure HttpSecurity Any endpoint that requires defense against common
	 * vulnerabilities can be specified here, including public ones
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		LOGGER.info("START");

		http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and()
				.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		LOGGER.info("END");

	}

	/**
	 * to configure WebSecurity. For eg: if you wish to ignore certain requests
	 */

	@Override
	public void configure(WebSecurity web) throws Exception {
		LOGGER.info("START");

		web.ignoring().antMatchers("/authapp/login", "/h2-console/**", "/v2/api-docs", "/configuration/ui",
				"/configuration/security", "/webjars/**");
		LOGGER.info("END");

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		LOGGER.info("START");
		LOGGER.info("END");
		return super.authenticationManagerBean();
	}

}
