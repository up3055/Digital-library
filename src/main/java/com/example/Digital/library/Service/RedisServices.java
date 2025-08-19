package com.example.Digital.library.Service;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServices {


    private final RedisTemplate<String , Object> redisTemplate;

    public RedisServices(RedisTemplate<String , Object> redisTemplate){
        this.redisTemplate =redisTemplate;
    }


    public void save(String key , Object value){
        redisTemplate.opsForValue().set(key , value);
    }

    public Object get(String key){

     return   redisTemplate.opsForValue().get(key);

    }
    public void delete(String key){

        redisTemplate.delete(key);
    }






}
