package im.connection;

import im.Server;
import im.container.ModuleAdapter;

/**
 * Created by tianxing on 16/12/6.
 */
public class ConnectionManagerImp extends ModuleAdapter implements ConnectionManager {













    public ConnectionManagerImp(String moduleName) {
        super(moduleName);
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
        super.start();
    }


    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void destory() {
        super.destory();
    }
}
