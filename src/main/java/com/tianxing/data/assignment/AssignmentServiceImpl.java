package com.tianxing.data.assignment;

import com.tianxing.service.AbstractService;
import com.tianxing.service.AssignmentService;
import com.tianxing.service.ServiceMediator;

import static com.tianxing.service.AssignmentService.ServiceName;

/**
 * Created by tianxing on 2017/3/28.
 *
 */
public class AssignmentServiceImpl extends AbstractService implements AssignmentService {


    private static AssignmentServiceImpl service;

    private AssignmentServiceImpl(ServiceMediator mediator) {
        super(mediator);
    }

    @Override
    public String getServiceName() {
        return ServiceName;
    }


    public static AssignmentServiceImpl getInstance(ServiceMediator mediator){
        if (service == null){
            service = new AssignmentServiceImpl(mediator);
        }
        return service;
    }

}
