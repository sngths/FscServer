package im.connection;

import im.Server;
import im.container.ModuleAdapter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tianxing on 16/12/6.
 */
public class ConnectionManagerImp extends ModuleAdapter implements ConnectionManager {



    private final ConnectionListener cilentListener;










    /**
     * 初始化时 创建各个ConnectionListener
     * */
    public ConnectionManagerImp() {
        super("connection manager");


        //客户端到服务器端的连接监听
        cilentListener = new ConnectionListener();

    }





    private synchronized void startListeners(){

        getListeners().forEach(ConnectionListener::start);

    }



    private synchronized void stopListeners(){
        getListeners().forEach(ConnectionListener::stop);
    }



    public ConnectionListener getListener(){
        return cilentListener;
    }


    public Set<ConnectionListener> getListeners(){
        Set<ConnectionListener> listeners = new HashSet<>();
        listeners.add(cilentListener);

        return listeners;
    }


    // #####################################################################
    // 模块生命周期
    // #####################################################################


    @Override
    public void initialize(Server server) {
        super.initialize(server);
    }

    @Override
    public void start() {
        startListeners();
        super.start();
    }


    @Override
    public void stop() {
        stopListeners();
        super.stop();
    }

    @Override
    public void destory() {
        super.destory();
    }
}
