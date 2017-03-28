package com.tianxing.redis.client;

import com.tianxing.redis.RedisClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * Created by tianxing on 2017/3/7.
 * jedis操作接口 使用连接池处理请求
 */
public class JedisStorageClient implements RedisClient {


    private final JedisPool pool;


    public JedisStorageClient() {
        this(RedisConfig.builder().buildDefault());
    }

    public JedisStorageClient(RedisConfig config) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(config.getMaxTotal());
        poolConfig.setMaxIdle(config.getMaxIdle());
        poolConfig.setMinIdle(config.getMinIdle());
        pool = new JedisPool(poolConfig, config.getHost(), config.getPort());

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
