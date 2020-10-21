package com.health.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @author liunan13
 * @date 2019/3/20
 * @description
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisStandaloneConfigProperties redisStandaloneConfigProperties;

    @Component
    @ConfigurationProperties(prefix = "spring.redis")
    @Data
    public class RedisStandaloneConfigProperties {
        private String password;
        private String host;
        private Integer port;
        private Integer database;
    }

    @Bean(name = "connectionFactory")
    public JedisConnectionFactory getJedisConnectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(25);
        poolConfig.setMinIdle(2);
        poolConfig.setMaxIdle(5);

        JedisClientConfiguration config = JedisClientConfiguration
                .builder()
                .connectTimeout(Duration.ofMillis(3000))
                .readTimeout(Duration.ofMillis(3000))
                .usePooling()
                .poolConfig(poolConfig)
                .build();

        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setDatabase(redisStandaloneConfigProperties.getDatabase());
        configuration.setHostName(redisStandaloneConfigProperties.getHost());
        configuration.setPort(redisStandaloneConfigProperties.getPort());
        configuration.setPassword(RedisPassword.of(redisStandaloneConfigProperties.getPassword()));
        return new JedisConnectionFactory(configuration, config);
    }

}
