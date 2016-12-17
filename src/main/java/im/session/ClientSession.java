package im.session;

import im.exception.UserNotFoundException;

/**
 * Created by tianxing on 16/12/16.
 */
public interface ClientSession extends Session {



    /**
     * 用户未完成认证 则抛出异常
     * */
    String getUsername() throws UserNotFoundException;


    boolean isAnonymousUser();
}
