package im.connection;

import im.auth.UnauthorizedException;
import im.handler.ClientStanzaHandler;
import im.handler.StanzaHandler;
import im.message.Packet;
import im.session.LocalSession;

/**
 * Created by tianxing on 16/12/17.
 *
 *
 *
 */
public class NIOConnection implements Connection {






    public NIOConnection(){
        //创建StanzaHandler
    }

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
        return new ClientStanzaHandler();
    }

    @Override
    public void deliver(Packet packet) throws UnauthorizedException {

    }
}
