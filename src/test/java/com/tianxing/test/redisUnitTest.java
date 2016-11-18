package com.tianxing.test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by tianxing on 16/9/27.
 */
public class redisUnitTest {


    //@Test
    public void test1() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //poolConfig.s
        Jedis jedis = new Jedis("Localhost", 6379);
        Long a = 923429349324L;
        //jedis.zadd("as", a, "ad");
        //jedis.append(new byte[2], new byte[1]);
        jedis.set("key".getBytes(), "value".getBytes());
        jedis.expire("key".getBytes(), 30);
        System.out.println(new String(jedis.get("key".getBytes())));
        HostAndPort hostAndPort = new HostAndPort("asd", 124334);

        jedis.pipelined();
        BigInteger bigInteger = new BigInteger(64, 64, new Random(123));
    }

}
