package com.tianxing.service;

import com.tianxing.data.InfoServiceImpl;
import com.tianxing.account.AccountServiceImpl;
import com.tianxing.data.assignment.AssignmentServiceImpl;
import com.tianxing.session.SessionServiceImpl;
import com.tianxing.log.LogServiceImpl;

import javax.validation.constraints.NotNull;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tianxing on 2017/3/28.
 * 服务仲裁 集中处理服务间交互
 */
public class ServiceMediatorImpl implements ServiceMediator {

    private ConcurrentHashMap<String, Service> serviceMap;


    public ServiceMediatorImpl(){
        this.serviceMap = new ConcurrentHashMap<>();
    }



    @Override
    public void registerService(@NotNull Service service) {
        if (service.getServiceName() == null || service.getServiceName().equals("")){
            throw new RuntimeException("服务名称不可为空");
        }
        if (service == null){
            throw new RuntimeException("服务不可为空");
        }
        serviceMap.put(service.getServiceName(), service);
    }


    @Override
    public AccountService getAccountService() {
        return (AccountService) getService(AccountService.ServiceName);
    }

    @Override
    public AssignmentService getAssignmentService() {
        return (AssignmentService) getService(AssignmentService.ServiceName);
    }

    @Override
    public InfoService getInfoService() {
        return (InfoService) getService(InfoService.ServiceName);
    }

    @Override
    public LogService getLogService() {
        return (LogService) getService(LogService.ServiceName);
    }

    @Override
    public SessionService getSessionService() {
        return (SessionService) getService(SessionService.ServiceName);
    }

    /**
     * 取得服务实例
     * */
    private Service getService(String serviceName){
        Service service = serviceMap.get(serviceName);
        if (service != null){
            return service;
        }
        synchronized (this){
            service = serviceMap.get(serviceName);
            if (service != null){
                return service;
            }else {
                switch (serviceName){
                    case AccountService.ServiceName:
                        service = AccountServiceImpl.getInstance(this);
                        break;
                    case AssignmentService.ServiceName:
                        service = AssignmentServiceImpl.getInstance(this);
                        break;
                    case InfoService.ServiceName:
                        service = InfoServiceImpl.getInstance(this);
                        break;
                    case LogService.ServiceName:
                        service = LogServiceImpl.getInstance(this);
                        break;
                    case SessionService.ServiceName:
                        service = SessionServiceImpl.getInstance(this);
                        break;
                    default:
                        throw new RuntimeException("请求服务不存在!");
                }
                serviceMap.put(serviceName, service);
                return service;
            }
        }
    }



}
