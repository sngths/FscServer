package im.connection;

import im.session.StanzaHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;

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
        //创建Connection和StanzaHandler
        Connection connection = createConnection(ch);

    }


    /**
     *
     * */




    /**
     *
     * */
    abstract Connection createConnection(Channel channel);



    /**
     *
     * */
    abstract StanzaHandler createStanzaHandler();
}
