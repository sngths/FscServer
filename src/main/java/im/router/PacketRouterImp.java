package im.router;

import im.Server;
import im.container.ModuleAdapter;
import im.message.IQ;
import im.message.Message;
import im.message.Packet;
import im.message.Presence;

/**
 * Created by tianxing on 16/12/7.
 *
 */
public class PacketRouterImp extends ModuleAdapter implements PacketRouter {



    private IQRouter iqRouter;
    private MessageRouter messageRouter;
    private PresenceRouter presenceRouter;




    public PacketRouterImp(String moduleName) {
        super(moduleName);
    }

    @Override
    public void route(Packet packet) {
        if (packet instanceof IQ){
            route((IQ)packet);
        }else if (packet instanceof Message){
            route((Message)packet);
        }else if (packet instanceof Presence){
            route((Presence)packet);
        }else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void route(IQ packet) {
        iqRouter.route(packet);
    }

    @Override
    public void route(Message packet) {
        messageRouter.route(packet);
    }

    @Override
    public void route(Presence packet) {
        presenceRouter.route(packet);
    }


    @Override
    public void initialize(Server server) {
        //获取各个消息路由模块

    }
}
