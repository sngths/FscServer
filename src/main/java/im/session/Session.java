package im.session;

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




}
