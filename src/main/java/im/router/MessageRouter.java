package im.router;

import im.Server;
import im.container.ModuleAdapter;
import im.message.Message;
import im.offlineMessage.OfflineMessageStrategy;
import im.session.ClientSession;
import im.session.SessionManager;

/**
 * Created by tianxing on 16/12/7.
 *
 * 消息路由器 一般先把消息路由到内部组件去处理,然后返回到路由器发送到接受者
 *
 */
public class MessageRouter extends ModuleAdapter{

    private OfflineMessageStrategy offlineMessageStrategy;
    private RoutingTable routingTable;
    private SessionManager sessionManager;
    private MulticastRouter multicastRouter;


    private String serverName;




    public MessageRouter() {
        super("message router");
    }




    public void route(Message message){
        if (message == null){
            throw new NullPointerException();
        }
        //ClientSession session =



    }

    @Override
    public void initialize(Server server) {

    }


    public void routingFailed(){

    }
}
