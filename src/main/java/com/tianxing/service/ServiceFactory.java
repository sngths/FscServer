package com.tianxing.service;

/**
 * Created by tianxing on 2017/3/28.
 * 完成各个服务的创建和配置
 */
public interface ServiceFactory {

    /**
     * 创建服务实例 需要加锁 防止多线程下实例被多次创建
     * */
    Service createService(String serviceName, ServiceMediator mediator);

    /**
     * 创建各个服务实例
     * */
    Service createAccountService(ServiceMediator mediator);

    Service createAssignmentService(ServiceMediator mediator);

    Service createInfoService(ServiceMediator mediator);

    Service createLogService(ServiceMediator mediator);

    Service createSessionService(ServiceMediator mediator);
}
