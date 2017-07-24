package com.tianxing.components.mediator;



import com.tianxing.components.*;

import javax.validation.constraints.NotNull;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tianxing on 2017/3/28.
 * 服务仲裁 集中处理服务间交互
 */
public class ComponentMediatorImpl implements ComponentMediator {


    private ConcurrentHashMap<String, Component> components;

    private ServiceFactory factory;

    public ComponentMediatorImpl(){
        this.components = new ConcurrentHashMap<>();
        factory = new DefaultServiceFactory();
    }



    @Override
    public void registerComponent(@NotNull Component component) {
        if (component.getName() == null || component.getName().equals("")){
            throw new RuntimeException("服务名称不可为空");
        }
        component.initialize(this);
        components.put(component.getName(), component);
        component.start();
    }

    @Override
    public <T extends Component> void register(@NotNull T t) {
        String serviceName = t.getName();
        if (serviceName == null || serviceName.equals("")){
            serviceName = t.getClass().getSimpleName().toLowerCase();
        }
        t.initialize(this);
        components.put(serviceName, t);
        t.start();
    }

    @Override
    public void setFactory(ServiceFactory factory) {
        this.factory = factory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T extends Component> T getComponent(Class<T> tClass) {
        String name = tClass.getSimpleName().toLowerCase();
        T t = (T) components.get(name);
        if (t == null){
            throw new RuntimeException("module not exist");
        }
        return t;
    }



    /**
     * 取得服务实例
     *
     * */
    public Component getComponent(String name){
        Component component = components.get(name);
        if (component == null){
            throw new RuntimeException("module not exist");
        }
        return component;

        /*synchronized (this){
            module = components.get(name);
            if (module != null){
                return module;
            }else {
                module = factory.createService(name, this);
                components.put(name, module);
                return module;
            }
        }*/
    }

    @Override
    public void stopAll() {
        components.values().forEach(Component::stop);
    }

    @Override
    public void destroyAll() {
        components.values().forEach(Component::destroy);
    }


    /**
     * 创建服务实例
     * */
    private Component CreateService(){
        return null;
    }



}
