package com.tianxing.redisTest;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by tianxing on 16/9/27.
 */
public class redisUnitTest {


    //@Test
    public void test1() {
        Jedis jedis = new Jedis("Localhost", 6379);
        Long a = 923429349324L;
        //jedis.zadd("as", a, "ad");
        //jedis.append(new byte[2], new byte[1]);
        jedis.set("key".getBytes(), "value".getBytes());
        jedis.expire("key".getBytes(), 30);
        System.out.println(new String(jedis.get("key".getBytes())));
    }

}
