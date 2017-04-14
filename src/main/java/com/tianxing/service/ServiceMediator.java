package com.tianxing.service;

/**
 * Created by tianxing on 2017/3/28.
 * 中介者 处理服务模块间的交互
 */
public interface ServiceMediator {





    /**
     * 注册一个服务
     * */
    void registerService(Service service);

    /**
     * 设置服务工厂
     * */
    void setFactory(ServiceFactory factory);
    /**
     * 获取相应服务
     * */
    AccountService getAccountService();
    AssignmentService getAssignmentService();
    InfoService getInfoService();
    LogService getLogService();
    SessionService getSessionService();


}
