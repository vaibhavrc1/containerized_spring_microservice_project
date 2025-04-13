package com.companyname.caching.config;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.time.Duration;

@EnableCaching
@Configuration
public class CacheConfig {

    @Bean
    public CacheManager ehCacheManager() {
        CachingProvider provider = Caching.getCachingProvider();
        CacheManager cacheManager = provider.getCacheManager();

        // Configure cache for employee entities
        javax.cache.configuration.Configuration<Object, Object> employeeConfiguration =
                Eh107Configuration.fromEhcacheCacheConfiguration(
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                                        Object.class, Object.class,
                                        ResourcePoolsBuilder.heap(1000))  // matches your previous heap size
                                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(600)))  // matches your previous TTL
                                .build());

        // Create employee cache with the configuration
        cacheManager.createCache("employee", employeeConfiguration);

        return cacheManager;
    }
}
