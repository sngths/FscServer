package im.connection;

/**
 * Created by tianxing on 16/12/12.
 */
public class ConnectionListener {

    private ConnectionAcceptor connectionAcceptor;






    /**
     * 根据配置创建ConnectionAccept
     * */
    public synchronized void start(){

        connectionAcceptor  = new NettyConnectionAcceptor(new ConnectionConfiguration());


        connectionAcceptor.start();

    }


    public synchronized void stop(){

    }


    public synchronized void restart(){

    }
}
