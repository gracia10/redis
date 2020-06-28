package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RedisRunner implements ApplicationRunner{

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String,String> values = redisTemplate.opsForValue();
        values.set("name", "wasabi");

        System.out.println("opsForValue:"+values.get("name"));

        Map<String, String> empBobMap = new HashMap<>();
        empBobMap.put("name", "Bob");
        empBobMap.put("age", "26");
        empBobMap.put("id", "02");

        HashOperations<String, String, String> hash = redisTemplate.opsForHash();
        String empBobKey = "emp:Bob";
        hash.putAll(empBobKey, empBobMap);

        System.out.println("opsForValue:"+hash.entries(empBobKey));
    }
}
