package im.connection;

/**
 * Created by tianxing on 16/12/12.
 *
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
        if (connectionAcceptor == null){
            //未启动
            return;
        }

        try {
            connectionAcceptor.stop();
        }finally {
            connectionAcceptor = null;
        }
    }


    public synchronized void restart(){

        try {
            if (connectionAcceptor != null){
                connectionAcceptor.stop();
            }
        }finally {
            connectionAcceptor.start();
        }
    }


}
