package data.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tianxing on 16/10/28.
 * 处理客户端session
 */
public class SessionManager {

    private Map<String, Session> sessions = new ConcurrentHashMap<>();
    private Logger logger = LoggerFactory.getLogger(SessionManager.class);


    /**
     * 根据token取得session
     * @param token token即session的id
     * @return 返回可能为空
     * */
    public Session getSession(String token){
        return sessions.get(token);
    }




    /**
     * 创建用户session
     * */
    public Session createSession(String username){
        Session session = new Session();
        session.setUserName(username);
        String id = UUID.randomUUID().toString().replace("-" ,"");
        session.setId(id);
        logger.info("保存Session  用户名:".concat(session.getUserName()).concat("  token:").concat(session.getId()));
        sessions.put(id, session);
        return session;
    }
}
