/**
 *
 */
package com.sdjr2.rest_sp5_ztoe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

/**
 * {@link FakerBeanConfig} class.
 * <p>/**
 * Config - Java Faker External API to initialized Users.
 *
 * @author jroldan
 * @version 1.0
 * @category Bean
 * @since 22/12/26
 * @upgrade 22/12/26
 */
@Configuration
public class FakerBeanConfig {

    @Bean
    Faker getFaker() {
        return new Faker();
    }

}
