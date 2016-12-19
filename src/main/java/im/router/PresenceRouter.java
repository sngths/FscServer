package im.router;

import im.message.Presence;

/**
 * Created by tianxing on 16/12/7.
 *
 *
 *
 */
public class PresenceRouter {






    /**
     * 这个方法需要快速返回 避免耗时操作阻塞IO线程
     * 如果路由操作 耗时较长 则封装后放入新的线程执行
     * 路由方法支持并发调用
     * */
    public void route(Presence presence){

    }
}
