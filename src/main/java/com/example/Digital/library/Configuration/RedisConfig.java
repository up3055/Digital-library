package com.example.Digital.library.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String , Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String , Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // Use JSON serialization for values

        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);

        template.setKeySerializer(new StringRedisSerializer());

        template.setValueSerializer(serializer);

        template.setHashKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        template.afterPropertiesSet();

        return template;
    }
}
