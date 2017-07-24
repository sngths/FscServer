package com.tianxing.components;

import com.tianxing.components.mediator.ComponentMediator;

/**
 * Created by tianxing on 2017/3/28.
 * 完成各个服务的创建和配置
 */
public interface ServiceFactory {

    /**
     * 创建服务实例 需要加锁 防止多线程下实例被多次创建
     * */
    Component createService(String serviceName, ComponentMediator mediator);

    /**
     * 创建各个服务实例
     * */
    Component createAccountService(ComponentMediator mediator);

    Component createAssignmentService(ComponentMediator mediator);

    Component createInfoService(ComponentMediator mediator);

    Component createLogService(ComponentMediator mediator);

    Component createSessionService(ComponentMediator mediator);
}
