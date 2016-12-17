package im.connection;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import im.auth.UnauthorizedException;
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



    void deliver(Packet packet) throws UnauthorizedException;





}
