package com.tianxing.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.traffic.GlobalTrafficShapingHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.net.SocketAddress;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tianxing on 16/11/30.
 */
public class Main {

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChildChannelHandler());

            //绑定端口开始接受连接请求
            ChannelFuture channelFuture = bootstrap.bind(12345).sync();
            //等待端口关闭
            //channelFuture.channel().closeFuture().sync();



            //第二个服务器监听端口
            ServerBootstrap bootstrap1 = new ServerBootstrap();
            bootstrap1.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChildChannelHandler());
            bootstrap1.bind(12346).sync();


        } catch (InterruptedException e) {
            e.printStackTrace();
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            System.out.println("服务关闭完成");
        }
    }


    private static class ChildChannelHandler extends ChannelInitializer {


        @Override
        protected void initChannel(Channel ch) throws Exception {

            //创建链接时控制连接总数

            //netty 会为每个channel创建一个独立的pipeline
            //inBound按正序处理
            //LengthFieldBasedFrameDecoder decoder = new LengthFieldBasedFrameDecoder();
            //ch.pipeline().addLast(new FixedLengthFrameDecoder(30));//定长数据解码器
            ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(32767, 0, 4, 0, 4, false));//16位short最大32767 = 32kb   32位int最大 2147483648 = 2GB  无符号最大 4294967295 = 4GB

            //ch.pipeline().addLast("StringDecoder", new StringDecoder(CharsetUtil.UTF_8));//字符串解码器
            ch.pipeline().addLast(new MessageHandler());


            //outbound  按逆序处理
            ch.pipeline().addLast("LengthFieldPrepender", new LengthFieldPrepender(4, false));//在消息头部添加 数据长度 长度信息占用4个字节 长度字节不算在总长度中
            System.out.println("服务端接收到连接请求");

        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            super.channelActive(ctx);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            super.exceptionCaught(ctx, cause);
        }
    }


    /**
     * 消息解码
     * */
    private class MessageDecoder extends ByteToMessageDecoder {

        @Override
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        }
    }

    /**
     * 消息转型
     * */


    /**
     * 处理由I/O线程触发的事件
     * */
    private static class MessageHandler extends ChannelInboundHandlerAdapter{


        //Handler中的方法  调用父类对应的方法 则交给责任链中的下一个Handler执行
        AtomicInteger count = new AtomicInteger(0);

        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            super.channelRegistered(ctx);
            //心跳处理
            //ctx.executor().scheduleAtFixedRate()
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            super.channelActive(ctx);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            //super.channelRead(ctx, msg);
            //没有转码前 meg 对象 为 ByteBuf
            //ctx.fireChannelRead(msg);
            //System.out.println("收到一条消息");
            int type = ((ByteBuf)msg).readByte();
            String message = ((ByteBuf)msg).toString(CharsetUtil.UTF_8);
            count.incrementAndGet();
            if (count.get() > 10000){
                System.out.println("消息类型:" + type + "  消息内容:" + message);
                count.set(0);
            }
            ((ByteBuf)msg).release();

        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            //super.channelReadComplete(ctx);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }

        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
            super.userEventTriggered(ctx, evt);
        }

        @Override
        public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
            super.channelWritabilityChanged(ctx);
        }


        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            //Handler添加时 执行的操作

        }

        @Override
        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
            //handler移除时 执行的操作
        }

    }


    /**
     * 处理由用户主动发起的I/O操作
     * */
    private class SendHandler extends ChannelOutboundHandlerAdapter{
        //


        @Override
        public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
            super.bind(ctx, localAddress, promise);
        }

        @Override
        public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
            super.connect(ctx, remoteAddress, localAddress, promise);
        }

        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            super.write(ctx, msg, promise);

        }

        @Override
        public void flush(ChannelHandlerContext ctx) throws Exception {
            super.flush(ctx);
        }

        @Override
        public void read(ChannelHandlerContext ctx) throws Exception {
            super.read(ctx);
        }

        @Override
        public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
            super.disconnect(ctx, promise);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            //
            return super.clone();
        }
    }


    /**
     * 认知
     * */
    private class LoginHandler{

    }



    /**
     * 心跳检测
     * */
    private class HeartBeatRequestHandler{

    }



    /**
     * 全局流量整形  控制流量处理速率 防止处理模块无法及时处理
     * */
    private class TrafficShaping extends GlobalTrafficShapingHandler {

        public TrafficShaping(ScheduledExecutorService executor, long writeLimit, long readLimit, long checkInterval, long maxTime) {
            super(executor, writeLimit, readLimit, checkInterval, maxTime);
        }
    }

    /**
     * 链路级流量整形
     * */



    public void a(){
        //channelGroup用来保存channel 处理群发 事件
        ChannelGroup recipients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
        //recipients.add();
        //recipients.remove();
        recipients.write(new Object());






    }
}
