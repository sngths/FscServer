package im.container;

import im.Server;

/**
 * Created by tianxing on 16/12/1.
 *
 */
public interface Module {




    /**
     * 返回当前模块名称
     * */
    String getName();


    /**
     * 初始化模块
     * */
    void initialize(Server server);

    /**
     * 启动模块 快速返回,耗时操作在新线程下执行。
     * */
    void start();


    /**
     * 停止模块  停止所有线程 准备好销毁或者重新初始化
     * */
    void stop();

    /**
     * 销毁模块
     * */
    void destory();
}
