package com.tianxing.redis.client;

import com.tianxing.redis.RedisClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Created by tianxing on 2017/3/7.
 * jedis操作接口 使用连接池处理请求
 */
public class JedisClient implements RedisClient {


    private final JedisPool pool;


    public JedisClient(String host, int port) {
        this(host, port, 5);
    }

    public JedisClient(String host, int port, int max) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(max);
        config.setMaxIdle(3);
        config.setMinIdle(1);
        config.setTestOnBorrow(true);
        config.setTestWhileIdle(true);
        pool = new JedisPool(config, host, port);
    }


    public void set(){
        try (Jedis jedis = pool.getResource()) {

            jedis.dbSize();


            jedis.set("", "", "");
        }



    }


    @Override
    public void close() {
        pool.destroy();
    }





    private void string(){
        try (Jedis jedis = pool.getResource()){
            jedis.get("");
            jedis.set("", "", "");

            String a = "";
            a.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
