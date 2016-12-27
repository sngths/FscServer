package im.connection;

import im.auth.UnauthorizedException;
import im.handler.StanzaHandler;
import im.message.Packet;
import im.session.LocalSession;

/**
 * Created by tianxing on 16/12/9.
 *
 *
 *
 */
public class ClientSessionConnection extends VirtualConnection {

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public void init(LocalSession session) {

    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public String getHostName() {
        return null;
    }

    @Override
    public StanzaHandler createStanzaHandler() {
        return null;
    }

    @Override
    public void deliver(Packet packet) throws UnauthorizedException {

    }
}
