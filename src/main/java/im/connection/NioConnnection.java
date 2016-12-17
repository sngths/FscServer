package im.connection;

import im.auth.UnauthorizedException;
import im.message.Packet;
import im.session.LocalSession;

/**
 * Created by tianxing on 16/12/16.
 */
public class NioConnnection implements Connection {






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
    public void deliver(Packet packet) throws UnauthorizedException {

    }
}
