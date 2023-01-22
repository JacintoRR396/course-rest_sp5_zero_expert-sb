package com.sdjr2.rest_sp5_ztoe.config;

import java.util.HashMap;
import java.util.Map;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
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
	/*
	@Bean public CacheManager getCacheManager() {
		return new ConcurrentMapCacheManager("profiles", "users", "roles", "addresses");
	}
	*/
	@Bean public CacheManager getCacheManager( RedissonClient redissonClient ) {
		Map<String, CacheConfig> config = new HashMap<>();
		config.put( "users", new CacheConfig() );
		return new RedissonSpringCacheManager( redissonClient );
	}

	@Bean(destroyMethod ="shutdown") public RedissonClient redisson() {
		Config config = new Config();
		config.useSingleServer().setAddress("redis://127.0.0.1:6379");
		return Redisson.create(config);
	}
	
}
