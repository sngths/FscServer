package com.tianxing.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.junit.Test;

/**
 * Created by tianxing on 16/11/18.
 *
 */
public class NettyTest {








    @Test
    public void start(){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChildChannelHandler());

            //绑定端口开始接受连接请求
            ChannelFuture channelFuture = bootstrap.bind(12346).sync();
            //等待端口关闭
            channelFuture.channel().closeFuture().sync();


        } catch (InterruptedException e) {
            e.printStackTrace();
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            System.out.println("服务关闭完成");
        }
    }




    private class ChildChannelHandler extends ChannelInitializer{


        @Override
        protected void initChannel(Channel ch) throws Exception {
            //LengthFieldBasedFrameDecoder decoder = new LengthFieldBasedFrameDecoder();
            //ch.pipeline().addLast(new FixedLengthFrameDecoder(30));//定长数据解码器
            ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(2147483647, 0, 4, 0, 4, false));//32位int最大 2147483648 = 2GB  无符号最大 4294967295 = 4GB
            //ch.pipeline().addLast("LengthFieldPrepender", new LengthFieldPrepender(4, false));//在消息头部添加 数据长度 长度信息占用4个字节 长度字节不算在总长度中
            ch.pipeline().addLast("StringDecoder", new StringDecoder(CharsetUtil.UTF_8));//字符串解码器
            ch.pipeline().addLast(new MessageHandler());

        }
    }


    private class MessageHandler extends ChannelInboundHandlerAdapter{

        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            super.handlerAdded(ctx);
        }

        @Override
        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
            super.handlerRemoved(ctx);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            super.channelRead(ctx, msg);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            super.channelReadComplete(ctx);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
    }


    public void a(){
        ChannelGroup recipients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
        //recipients.add();
        //recipients.remove();

    }
}
