package im.connection;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * Created by tianxing on 16/12/5.
 *
 */
public class NettyConnectionAcceptor extends ConnectionAcceptor {


    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;

    private ConnectionHandler connectionHandler;


    /**
     * 根据配置 创建不同的连接监听器
     * */
    public NettyConnectionAcceptor(ConnectionConfiguration configuration) {
        super(configuration);


    }

    @Override
    public synchronized void start() {


    }

    @Override
    public synchronized void stop() {

    }
}
