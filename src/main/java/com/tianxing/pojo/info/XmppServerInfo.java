package com.tianxing.pojo.info;

/**
 * Created by tianxing on 16/8/31.
 * xmpp服务器相关信息
 */
public class XmppServerInfo {




    private String serviceName = "raspberrypi3";
    private String host = "172.24.1.1";
    private Integer port = 5222;
    private String resource = "Smack";
    private String roomServiceName = "conference.raspberrypi3";
    private String username = "user1";
    private String password = "123456";

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setRoomServiceName(String roomServiceName) {
        this.roomServiceName = roomServiceName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public String getResource() {
        return resource;
    }

    public String getRoomServiceName() {
        return roomServiceName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
