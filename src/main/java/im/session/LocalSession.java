package im.session;

import com.tianxing.data.session.SessionManager;
import im.connection.Connection;
import im.message.Packet;
import im.stream.StreamManager;
import im.util.StreamID;
import im.util.UID;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tianxing on 16/12/2.
 * 服务器连接到客户端 服务器 或外部组件等  的会话
 */
public abstract class LocalSession implements Session {

    private UID uid;

    private StreamID streamID;

    /**
     * 当前连接状态
     */
    protected int status = STATUS_CONNECTED;


    private String serverName;

    private long startDate = System.currentTimeMillis();

    private long lastActiveDate;
    private long clientPacketCount = 0;
    private long serverPacketCount = 0;


    /**
     * session所包含的网络连接
     */
    private Connection connection;

    protected SessionManager sessionManager;

    protected StreamManager streamManager;


    /**
     * session中临时存储的数据 和session的生命周期相同
     */
    private Map<String, Object> sessionData = new HashMap<>();


    public LocalSession(String serverName, Connection connection, StreamID streamID) {
        if (connection == null) {
            throw new IllegalArgumentException("连接不能为空");
        }
        this.serverName = serverName;
        this.connection = connection;
        this.streamID = streamID;
    }


    public void incrementClientPacketCount(){

    }




    public void incrementServerPacketCount(){

    }





    public void setSessionData(String key, Object value){

    }


    public Object getSessionDate(String key){
        return null;
    }


    public void removeSessionData(String key){

    }




    public void process(Packet packet){

    }


}
