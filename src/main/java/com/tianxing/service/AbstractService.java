package com.tianxing.service;

/**
 * Created by tianxing on 2017/3/28.
 *
 */
public abstract class AbstractService implements Service{


    protected final ServiceMediator mediator;

    protected AbstractService(ServiceMediator mediator) {
        this.mediator = mediator;
    }


}
