package com.tianxing.redis.client;

import com.tianxing.redis.RedisClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

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





    @Override
    public void close() {
        pool.destroy();
    }




    private byte[] encodingUTF_8(String string){
        return string.getBytes(StandardCharsets.UTF_8);
    }




    /**
     * String类型
     * */
    private void string(){
        try (Jedis jedis = pool.getResource()){
            jedis.set("string", "value");
            jedis.get("string");

            String a = "";
            byte b[] = a.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * HashMap类型
     * */
    private void hashMap(){
        ByteBuffer buffer = ByteBuffer.allocate(100);
        try (Jedis jedis = pool.getResource()){

        }

    }

    /**
     * Set类型
     * */
    private void set(){
        try(Jedis jedis = pool.getResource()) {
            jedis.sadd(encodingUTF_8(""), encodingUTF_8(""));
        }
    }

    /**
     * List类型
     * */

    /**
     * Sorted Set类型
     * */


}
