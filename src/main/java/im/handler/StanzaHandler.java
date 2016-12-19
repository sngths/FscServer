package im.handler;

import im.message.IQ;
import im.message.Message;
import im.message.Presence;
import im.router.PacketRouter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by tianxing on 16/12/14.
 *
 * 接收到认证 数据后创建session
 *
 */
public abstract class StanzaHandler extends ChannelInboundHandlerAdapter{



    private PacketRouter router;



    public StanzaHandler(PacketRouter router){
        this.router = router;
    }


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.fireChannelRead(msg);
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
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
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
    }




    /**
     * 处理消息包
     * */
    private void process(){

    }





    abstract void processIQ(IQ packet);

    abstract void processPresence(Presence packet);

    abstract void processMessage(Message packet);




    /**
     * 创建session
     * */
    abstract boolean createSession();




}