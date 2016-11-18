package com.tianxing.data.id;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tianxing on 16/11/1.
 * ID分发器  用于分发递增的数据类ID
 * 通过查询数据库获得 一批ID
 */
public class Dispatcher {

    private AtomicInteger atomicInteger = new AtomicInteger();
    
}
