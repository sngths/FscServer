package com.tianxing.cahce.strategy.redis;

import com.tianxing.cahce.Cache;
import com.tianxing.redis.RedisAPI;

/**
 * Created by tianxing on 2017/3/23.
 *
 */
public abstract class RedisCache implements Cache{

    private final RedisAPI api;

    public RedisCache(RedisAPI api) {
        this.api = api;
    }


}
