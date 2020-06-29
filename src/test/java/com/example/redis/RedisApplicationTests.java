package com.example.redis;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void redisBasicFunction_guide1(){

        //Given
        String key = "key";
        String value = "value";

        // redis에 set
        redisTemplate.opsForValue().set(key, value);

        // redis에서 get
        String result = (String) redisTemplate.opsForValue().get(key);      //value

        // redis에서 data delete
        redisTemplate.delete(key);

        // redis에 해당 key를 가지고 있는지 확인
        if (!redisTemplate.hasKey("999")) {
            System.out.println("key 미존재");
        }

        System.out.println(result);
    }

    @Test
    public void redisBasicFunction_guide2(){

        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        Employee employee = new Employee("myid","myname");

        valueOperations.set("employee", employee);

        Employee result = (Employee) valueOperations.get("employee");   // Employee [id=myid, name=myname, age=null]

        System.out.println(result);
    }

    @Test
    public void redisBasicFunction_guide3(){

        HashOperations<String, String, String> hash = redisTemplate.opsForHash();

        Map<String, String> empBobMap = new HashMap<>();
        empBobMap.put("name", "Bob");
        empBobMap.put("age", "26");
        empBobMap.put("id", "02");

        String empBobKey = "emp:Bob";

        hash.putAll(empBobKey, empBobMap);

        Map<String,String> result = hash.entries(empBobKey);    // {name=Bob, id=02, age=26}

        System.out.println(result);
    }
}
