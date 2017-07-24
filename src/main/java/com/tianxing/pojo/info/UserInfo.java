package com.tianxing.pojo.info;

/**
 * Created by tianxing on 16/8/31.
 *
 */
public class UserInfo {

    private String id = "";
    private String userName = "";
    private String nickName = "";
    private String userIconUrl = "";


    public static UserInfo newInstance(String userName){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        return userInfo;
    }


    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getUserIconUrl() {
        return userIconUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setUserIconUrl(String userIconUrl) {
        this.userIconUrl = userIconUrl;
    }
}
