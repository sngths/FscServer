package im.connection;

import im.handler.StanzaHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.Optional;

/**
 * Created by tianxing on 16/12/5.
 *
 * 接收到连接请求后 创建connection和StanzaHandler
 *
 */
public abstract class ConnectionHandler extends ChannelInitializer {

    private Optional<String> stringOptional = Optional.empty();




    public ConnectionHandler(ConnectionConfiguration configuration){

    }



    @Override
    protected void initChannel(Channel ch) throws Exception {
        //创建Connection
        Connection connection = createConnection(ch);

        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(32767, 0, 4, 0, 4, false));//16位short最大32767 = 32kb   32位int最大 2147483648 = 2GB  无符号最大 4294967295 = 4GB

        //ch.pipeline().addLast("StringDecoder", new StringDecoder(CharsetUtil.UTF_8));//字符串解码器
        ch.pipeline().addLast(connection.createStanzaHandler());
        ch.pipeline().addLast(new IdleStateHandler(120, 120, 0));//空闲检测 超时则触发超时事件 传递给下个Handler
        //ch.pipeline().addLast(new HeartBeatRequestHandler());//处理超时事件


    }


    /**
     *
     * */




    /**
     *
     * */
    abstract Connection createConnection(Channel channel);




}
