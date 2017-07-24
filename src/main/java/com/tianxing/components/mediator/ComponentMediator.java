package com.tianxing.components.mediator;

import com.tianxing.components.*;

/**
 * Created by tianxing on 2017/3/28.
 * 中介者 处理服务模块间的交互
 */
public interface ComponentMediator {



    /**
     * 注册一个服务
     * */
    void registerComponent(Component component);

    <T extends Component> void register(T t);

    /**
     * 设置服务工厂
     * */
    void setFactory(ServiceFactory factory);

    /**
     * 取得服务
     * */
    <T extends Component> T getComponent(Class<T> tClass);
    Component getComponent(String name);


    /**
     * 停止所有模块
     * */
    void stopAll();

    /**
     * 销毁所有模块
     * */
    void destroyAll();

}
