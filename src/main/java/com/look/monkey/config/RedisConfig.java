package com.look.monkey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * @author zhangxiaoyu
 */
@Configuration
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("117.78.0.112", 6379);
        redisStandaloneConfiguration.setPassword("");
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
    }
}
