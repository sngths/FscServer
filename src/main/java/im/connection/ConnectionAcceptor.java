package im.connection;

/**
 * Created by tianxing on 16/12/5.
 * 接受连接
 */
public abstract class ConnectionAcceptor {

    protected final ConnectionConfiguration configuration;

    public ConnectionAcceptor(ConnectionConfiguration configuration){
        if (configuration == null){
            throw new IllegalArgumentException("configuration 不能为空");
        }
        this.configuration = configuration;
    }

    /**
     * 创建开始接收连接
     * */
    abstract void start();



    /**
     * 停止接收连接
     * */
    abstract void  stop();



    /**
     * 判断当前是否空闲
     * */

}
