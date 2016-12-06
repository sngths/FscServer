package im.connection;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by tianxing on 16/12/5.
 */
public class NettyConnectionAcceptor extends ConnectionAcceptor {


    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;

    private ServerBootstrap bootstrap;

    private ConnectionHandler connectionHandler;


    /**
     * 根据配置 创建不同的连接监听器
     */
    public NettyConnectionAcceptor(ConnectionConfiguration configuration) {
        super(configuration);




        //创建Handler
        connectionHandler = new ClientConnectionHandler();
    }


    @Override
    public synchronized void start() {
        if (bossGroup != null || workerGroup != null) {
            //已启动
            return;
        }
        try {
            bossGroup = new NioEventLoopGroup();
            workerGroup = new NioEventLoopGroup();
            bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(connectionHandler);


            ChannelFuture channelFuture = bootstrap.bind(12345).sync();
            //等待端口关闭
            //channelFuture.channel().closeFuture().sync();



        } catch (InterruptedException e) {
            e.printStackTrace();
            try {
                bossGroup.shutdownGracefully().sync();
                workerGroup.shutdownGracefully().sync();
            } catch (InterruptedException e1) {
                e1.printStackTrace();

            }finally {
                bossGroup = null;
                workerGroup = null;
            }

        }


    }

    @Override
    public synchronized void stop() {
        if (bossGroup != null){
            try {
                bossGroup.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                bossGroup = null;
            }

            if (workerGroup != null){
                try {
                    workerGroup.shutdownGracefully().sync();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    workerGroup = null;
                }
            }

        }

    }


    /**
     * 参数配置
     * */

}
