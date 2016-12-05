package com.tianxing.netty.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.CharsetUtil;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tianxing on 16/11/24.
 *
 */
public class NettyClient {




    @Test
    public void start() throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitHandler());
            //发起异步连接
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 12345);

            //等待客户端链路关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }




    private class ChannelInitHandler extends ChannelInitializer{

        @Override
        protected void initChannel(Channel ch) throws Exception {

            //outbound  按逆序处理

            ch.pipeline().addLast("LengthFieldPrepender", new LengthFieldPrepender(4, false));//在消息头部添加 数据长度 长度信息占用4个字节 长度字节不算在总长度中
            ch.pipeline().addLast(new OutBoundMessageHandler());


            //inBound按正序处理
            //LengthFieldBasedFrameDecoder decoder = new LengthFieldBasedFrameDecoder();
            //ch.pipeline().addLast(new FixedLengthFrameDecoder(30));//定长数据解码器
            ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(32767, 0, 4, 0, 4, false));//16位short最大32767 = 32kb 无符号最大 65535 = 63kb  32位int最大 2147483648 = 2GB  无符号最大 4294967295 = 4GB

            ch.pipeline().addLast("StringDecoder", new StringDecoder(CharsetUtil.UTF_8));//字符串解码器
            ch.pipeline().addLast(new InBoundMessageHandler());
            System.out.println("客户端连接完成");


            //Random random = new Random(12321);
            AtomicInteger count = new AtomicInteger(0);
            final AtomicInteger courrentCount = new AtomicInteger(0);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = new Thread(() -> {
                while (true){

                    for (int i = 0; i < 500; i++) {
                        ch.write("aaaa" +  count.incrementAndGet());
                        if (count.get() - courrentCount.get() > 1000){
                            ch.flush();
                            courrentCount.set(count.get());
                        }
                    }
                    try {
                        Thread.currentThread().sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //System.out.println("发送消息" + count.get());
                }
            });
            thread.setDaemon(true);
            thread.start();

            //定时刷新

        }

    }


    /**
     * 接收消息
     * */
    private class InBoundMessageHandler extends ChannelInboundHandlerAdapter{


        //ByteBuf buf;

        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            //buf = ctx.alloc().buffer(1);
        }

        @Override
        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
            //buf.release();
            //buf = null;

        }



        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            super.channelRead(ctx, msg);

        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            super.channelReadComplete(ctx);
        }

    }


    /**
     * 发送消息
     * */
    private class OutBoundMessageHandler extends ChannelOutboundHandlerAdapter{
        ByteBuf buf = null;


        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        }

        @Override
        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {


        }
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {



            try {
                buf = ctx.alloc().buffer();
                buf.writeByte(1);//消息类型
                buf.writeBytes(((String)msg).getBytes());
                //ctx.write(buf, promise);
                //ctx.writeAndFlush(buf);

                //ctx.flush();
                ctx.write(buf);
                //buf = null;
            } finally {
                if (buf != null){
                    //buf.release();
                    buf = null;
                }
            }

        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            //buf.release();

        }
    }



}
