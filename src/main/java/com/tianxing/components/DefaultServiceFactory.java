package com.tianxing.components;

import com.tianxing.components.mediator.ComponentMediator;

/**
 * Created by tianxing on 2017/3/28.
 *
 */
public class DefaultServiceFactory implements ServiceFactory{


    @Override
    public synchronized Component createService(String serviceName, ComponentMediator mediator) {
        return null;
    }

    @Override
    public Component createAccountService(ComponentMediator mediator) {
        return createService(AccountManager.ServiceName, mediator);
    }

    @Override
    public Component createAssignmentService(ComponentMediator mediator) {
        return createService(AssignmentManager.ServiceName, mediator);
    }

    @Override
    public Component createInfoService(ComponentMediator mediator) {
        return createService(InfoManager.ServiceName, mediator);
    }

    @Override
    public Component createLogService(ComponentMediator mediator) {
        return createService(LogManager.ServiceName, mediator);
    }

    @Override
    public Component createSessionService(ComponentMediator mediator) {
        return createService(SessionManager.ServiceName, mediator);
    }
}
