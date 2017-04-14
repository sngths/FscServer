package com.tianxing.service;



import javax.validation.constraints.NotNull;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tianxing on 2017/3/28.
 * 服务仲裁 集中处理服务间交互
 */
public class ServiceMediatorImpl implements ServiceMediator {

    private ConcurrentHashMap<String, Service> serviceMap;

    private ServiceFactory factory;

    public ServiceMediatorImpl(){
        this.serviceMap = new ConcurrentHashMap<>();
        factory = new DefaultServiceFactory();
    }



    @Override
    public void registerService(@NotNull Service service) {
        if (service.getServiceName() == null || service.getServiceName().equals("")){
            throw new RuntimeException("服务名称不可为空");
        }
        serviceMap.put(service.getServiceName(), service);
    }

    @Override
    public void setFactory(ServiceFactory factory) {
        this.factory = factory;
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
                service = factory.createService(serviceName, this);
                serviceMap.put(serviceName, service);
                return service;
            }
        }
    }



}
