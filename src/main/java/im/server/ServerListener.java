package im.server;

/**
 * Created by tianxing on 16/11/25.
 * 反馈服务器状态
 */
public interface ServerListener {

    void serverStarted();



    void serverStopping();
}
