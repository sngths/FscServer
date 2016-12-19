package im.session;

import im.connection.Connection;
import im.util.StreamID;
import im.util.UID;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tianxing on 16/12/2.
 *
 */
public class LocalClientSession extends LocalSession {


    private static Set<String> allowedIPs = new HashSet<>();
    private static Set<String> allowedAnonymIPs = new HashSet<>();


    private static Set<String> blockedIPs = new HashSet<>();





    public LocalClientSession(String serverName, Connection connection, StreamID streamID) {
        super(serverName, connection, streamID);
    }




    /***
     * 创建session
     * */

    public static LocalClientSession createSession(){
        return null;
    }

    @Override
    public UID getUID() {
        return null;
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public StreamID getStreamID() {
        return null;
    }

    @Override
    public String getServerName() {
        return null;
    }

    @Override
    public Date getCreationDate() {
        return null;
    }

    @Override
    public Date getLastActiveDate() {
        return null;
    }

    @Override
    public long getNumClientPackets() {
        return 0;
    }

    @Override
    public long getNumServerPackets() {
        return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isClosed() {
        return false;
    }
}
