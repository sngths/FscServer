package data.account;

/**
 * Created by tianxing on 2016/10/29.
 *
 */
public class AccountManage {

    public enum UserType{Teacher, Student}



    /**
     * 验证用户名和密码
     * */
    public Boolean verify(String username, String password){
        return true;
    }

    /**
     * 验证用户类型
     * */
    public UserType getUserType(String username){
        return null;
    }

    /**
     * 用户登录 返回用户信息
     * */
}
