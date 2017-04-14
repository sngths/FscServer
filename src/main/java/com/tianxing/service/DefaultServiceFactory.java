package com.tianxing.service;

import com.tianxing.account.AccountServiceImpl;
import com.tianxing.data.InfoServiceImpl;
import com.tianxing.data.assignment.AssignmentServiceImpl;
import com.tianxing.log.LogServiceImpl;
import com.tianxing.session.SessionServiceImpl;

/**
 * Created by tianxing on 2017/3/28.
 *
 */
public class DefaultServiceFactory implements ServiceFactory{


    @Override
    public synchronized Service createService(String serviceName, ServiceMediator mediator) {
        if (serviceName == null || mediator == null){
            throw new NullPointerException();
        }
        Service service;
        switch (serviceName){
            case AccountService.ServiceName:
                service = AccountServiceImpl.getInstance(mediator);
                break;
            case AssignmentService.ServiceName:
                service = AssignmentServiceImpl.getInstance(mediator);
                break;
            case InfoService.ServiceName:
                service = InfoServiceImpl.getInstance(mediator);
                break;
            case LogService.ServiceName:
                service = LogServiceImpl.getInstance(mediator);
                break;
            case SessionService.ServiceName:
                service = SessionServiceImpl.getInstance(mediator);
                break;
            default:
                throw new RuntimeException("请求服务不存在!");
        }
        return service;
    }

    @Override
    public Service createAccountService(ServiceMediator mediator) {
        return createService(AccountService.ServiceName, mediator);
    }

    @Override
    public Service createAssignmentService(ServiceMediator mediator) {
        return createService(AssignmentService.ServiceName, mediator);
    }

    @Override
    public Service createInfoService(ServiceMediator mediator) {
        return createService(InfoService.ServiceName, mediator);
    }

    @Override
    public Service createLogService(ServiceMediator mediator) {
        return createService(LogService.ServiceName, mediator);
    }

    @Override
    public Service createSessionService(ServiceMediator mediator) {
        return createService(SessionService.ServiceName, mediator);
    }
}
