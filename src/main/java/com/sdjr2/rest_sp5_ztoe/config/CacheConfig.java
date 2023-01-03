package com.sdjr2.rest_sp5_ztoe.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Cache External API to manager caching.
 *
 * @author jroldan
 * @version 1.0
 * @category Bean
 * @since 23/01/03
 */
@Configuration
@EnableCaching
public class CacheConfig {
	
	@Bean public CacheManager getManager() {
		return new ConcurrentMapCacheManager("profiles", "users", "roles", "addresses");
	}

}
