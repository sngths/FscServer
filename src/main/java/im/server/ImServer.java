package im.server;

import im.Server;
import im.container.Module;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tianxing on 16/11/17.
 *
 */
public class ImServer implements Server {





    private Map<Class, ? extends Module> modules = new LinkedHashMap<>();











    /**
     * 加载模块
     * */
    private void loadModules(){

    }


    private void loadModule(String module){

    }


    /**
     * 初始化模块
     * */
    private void initializeModules(){

    }

    /**
     * 启动模块
     * */
    private void startModules(){

    }

}
