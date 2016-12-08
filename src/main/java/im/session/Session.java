package im.session;

import im.util.StreamID;
import im.util.UID;

import java.util.Date;

/**
 * Created by tianxing on 16/11/22.
 *
 * 表示一个 服务器端和客户端 服务器端和其他服务器端  服务器端和组件之间的连接
 *
 */
public interface Session {


    /**
     * 通信协议版本 (版本: 1.0)
     * */
    int MAJOR_VERSION = 1;
    int MINOR_VERSION = 0;

    /**
     * 连接状态
     * */
    int STATUS_CLOSED = -1;
    int STATUS_CONNECTED = 1;
    int STATUS_AUTHENTICATED = 3;


    UID getUID();

    int getStatus();

    StreamID getStreamID();

    String getServerName();

    Date getCreationDate();

    Date getLastActiveDate();

    /**
     * 服务器端接收的来自客户端的数据包数目
     * */
    long getNumClientPackets();

    /**
     * 服务器端发送给客户端的数据包数目
     * */

    long getNumServerPackets();

    /**
     * 设置关闭标志位 通知监听器会话关闭 关闭连接
     * */
    void close();

    boolean isClosed();




}
