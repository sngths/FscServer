package im.connection;


import io.netty.channel.Channel;

/**
 * Created by tianxing on 16/12/5.
 *
 * 接收客户端发起的连接
 */
public class ClientConnectionHandler extends ConnectionHandler {




    public ClientConnectionHandler(ConnectionConfiguration configuration) {
        super(configuration);
    }

    @Override
    Connection createConnection(Channel channel) {
        return new NIOConnection();
    }

}
