package com.tianxing.components;

import com.tianxing.components.mediator.ComponentMediator;

/**
 * Created by tianxing on 2017/3/28.
 * 服务模块接口
 */
public interface Component {


    String getName();


    void initialize(ComponentMediator mediator);


    void start();


    void stop();


    void destroy();

}
