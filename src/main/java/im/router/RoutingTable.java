package im.router;

import im.message.Packet;
import im.message.PacketException;
import im.session.*;
import im.util.UID;

import java.util.Collection;

/**
 * Created by tianxing on 16/12/7.
 *
 * 保存用户 服务器间的路由表  用户完成登陆后 session被添加到路由表中接接收路由消息
 */
public interface RoutingTable  {




    void addServerRoute(UID uid, LocalOutgoingServerSession session);

    void addComponentRoute(UID uid, Session session);

    void addClientRoute(UID uid, LocalClientSession session);

    void routePacket(UID uid, Packet packet, boolean formServer) throws PacketException;

    boolean hasClinetRoute(UID uid);

    boolean isAnonymousRoute(UID uid);

    boolean isLocalRoute(UID uid);

    boolean hasServerRoute(UID uid);

    boolean hasComponentRoute(UID uid);

    ClientSession getClientRoute(UID uid);

    /**
     * 获取全部客户端session
     * @param onlyLocal true只返回本地的客户端session  false返回包括连接到集群中其他服务器的客户端session
     * */
    Collection<ClientSession> getClientRoutes(boolean onlyLocal);

    OutgoingServerSession getServerRoute(UID uid);

    Collection<String> getServerHostNames();

    int getServerSessionsCount();

    Collection<String> getComponentsDomains();



}
