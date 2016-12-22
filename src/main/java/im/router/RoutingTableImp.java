package im.router;

import im.message.Packet;
import im.message.PacketException;
import im.session.*;
import im.util.UID;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tianxing on 16/12/10.
 *
 *
 *
 */
public class RoutingTableImp implements RoutingTable {



    private Map<String, Session> localRoutingTable = new ConcurrentHashMap<>();//保存连接到本地Session




    @Override
    public void addServerRoute(UID uid, LocalOutgoingServerSession session) {

    }

    @Override
    public void addComponentRoute(UID uid, Session session) {

    }

    @Override
    public void addClientRoute(UID uid, LocalClientSession session) {

    }

    @Override
    public void routePacket(UID uid, Packet packet, boolean formServer) throws PacketException {

    }

    @Override
    public boolean hasClientRoute(UID uid) {
        return false;
    }

    @Override
    public boolean isAnonymousRoute(UID uid) {
        return false;
    }

    @Override
    public boolean isLocalRoute(UID uid) {
        return false;
    }

    @Override
    public boolean hasServerRoute(UID uid) {
        return false;
    }

    @Override
    public boolean hasComponentRoute(UID uid) {
        return false;
    }

    @Override
    public ClientSession getClientRoute(UID uid) {
        return null;
    }

    @Override
    public Collection<ClientSession> getClientRoutes(boolean onlyLocal) {
        return null;
    }

    @Override
    public OutgoingServerSession getServerRoute(UID uid) {
        return null;
    }

    @Override
    public Collection<String> getServerHostNames() {
        return null;
    }

    @Override
    public int getServerSessionsCount() {
        return 0;
    }

    @Override
    public Collection<String> getComponentsDomains() {
        return null;
    }

    @Override
    public boolean removeServerRoute(UID uid) {
        return false;
    }

    @Override
    public boolean removeComponentRoute(UID uid) {
        return false;
    }

    @Override
    public boolean removeClientRoute(UID uid) {
        return false;
    }
}
