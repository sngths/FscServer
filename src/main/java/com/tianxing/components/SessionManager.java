package com.tianxing.components;

/**
 * Created by tianxing on 2017/3/28.
 *
 */
public interface SessionManager extends Component {
    String ServiceName = "sessionService";




    /**
     * 创建会话
     * */


    /**
     * 添加一个新的会话
     * */



    /**
     * 取得session
     * */


    /**
     * 统一保存session最后一次操作的时间戳
     * */

    long getLastAccessTime(String id);


}
