package com.tianxing.account;

import com.tianxing.service.AccountService;
import com.tianxing.service.ServiceMediator;

/**
 * Created by tianxing on 2017/3/28.
 *
 */
public class AccountServiceImpl implements AccountService {


    private static AccountService service;
    private final ServiceMediator mediator;


    private AccountServiceImpl(ServiceMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getServiceName() {
        return ServiceName;
    }


    public static AccountService getInstance(ServiceMediator mediator) {
        if (service == null){
            service = new AccountServiceImpl(mediator);
        }
        return service;
    }
}
