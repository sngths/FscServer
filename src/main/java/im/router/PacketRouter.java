package im.router;

import im.message.IQ;
import im.message.Message;
import im.message.Packet;
import im.message.Presence;

/**
 * Created by tianxing on 16/12/7.
 * 路由不同类型的数据包
 */
public interface PacketRouter {



    void route(Packet packet);



    void route(IQ packet);


    void route(Message packet);

    void route(Presence packet);
}
