package com.tianxing.session;

import com.tianxing.service.AbstractService;
import com.tianxing.service.ServiceMediator;
import com.tianxing.service.SessionService;

/**
 * Created by tianxing on 2017/3/28.
 *
 */
public class SessionServiceImpl extends AbstractService implements SessionService{


    private static SessionServiceImpl service;

    protected SessionServiceImpl(ServiceMediator mediator) {
        super(mediator);
    }

    public static SessionServiceImpl getInstance(ServiceMediator mediator) {
        if (service == null){
            service = new SessionServiceImpl(mediator);
        }
        return service;
    }
    @Override
    public String getServiceName() {
        return ServiceName;
    }
}
