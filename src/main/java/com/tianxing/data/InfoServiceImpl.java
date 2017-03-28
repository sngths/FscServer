package com.tianxing.data;

import com.tianxing.service.AbstractService;
import com.tianxing.service.InfoService;
import com.tianxing.service.ServiceMediator;

/**
 * Created by tianxing on 2017/3/28.
 */
public class InfoServiceImpl extends AbstractService implements InfoService {


    private static InfoServiceImpl service;
    private InfoServiceImpl(ServiceMediator mediator) {
        super(mediator);
    }

    public static InfoServiceImpl getInstance(ServiceMediator mediator) {
        if (service == null){
            service = new InfoServiceImpl(mediator);
        }
        return service;
    }



    @Override
    public String getServiceName() {
        return ServiceName;
    }

}
