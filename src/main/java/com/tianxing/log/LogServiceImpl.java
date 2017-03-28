package com.tianxing.log;

import com.tianxing.service.AbstractService;
import com.tianxing.service.LogService;
import com.tianxing.service.ServiceMediator;

/**
 * Created by tianxing on 2017/3/28.
 */
public class LogServiceImpl extends AbstractService implements LogService {



    private static LogServiceImpl service;
    private LogServiceImpl(ServiceMediator mediator) {
        super(mediator);
    }

    public static LogServiceImpl getInstance(ServiceMediator mediator) {
        if (service == null){
            service = new LogServiceImpl(mediator);
        }
        return service;
    }

    @Override
    public String getServiceName() {
        return ServiceName;
    }
}
