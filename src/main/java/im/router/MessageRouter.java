package im.router;

import im.Server;
import im.container.ModuleAdapter;

/**
 * Created by tianxing on 16/12/7.
 *
 * 消息路由器 一般先把消息路由到内部组件去处理,然后返回到路由器发送到接受者
 *
 */
public class MessageRouter extends ModuleAdapter{



    public MessageRouter() {
        super("message router");
    }




    public void route(){

    }

    @Override
    public void initialize(Server server) {
        super.initialize(server);
    }


    public void routingFailed(){

    }
}
