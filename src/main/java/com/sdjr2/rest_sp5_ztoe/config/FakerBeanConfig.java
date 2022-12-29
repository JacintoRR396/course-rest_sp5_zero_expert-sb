/**
 *
 */
package com.sdjr2.rest_sp5_ztoe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

/**
 * Java Faker External API.
 *
 * @author jroldan
 * @version 1.0
 * @category Bean
 * @since 22/12/26
 */
@Configuration
public class FakerBeanConfig {

	@Bean
	public Faker getFaker() {
		return new Faker();
	}

}
