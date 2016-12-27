package im.connection;

import im.auth.UnauthorizedException;
import im.handler.StanzaHandler;
import im.message.Packet;
import im.session.LocalSession;

/**
 * Created by tianxing on 16/12/6.
 *
 *
 */
public interface Connection {








    /**
     * 判断当前连接是否可用
     * */
    boolean validate();



    void init(LocalSession session);


    String getAddress();

    String getHostName();



    /**
     * 创建StanzaHandler
     * */
    StanzaHandler createStanzaHandler();


    void deliver(Packet packet) throws UnauthorizedException;





}
