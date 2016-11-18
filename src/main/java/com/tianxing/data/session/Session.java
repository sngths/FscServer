package com.tianxing.data.session;

/**
 * Created by tianxing on 16/10/28.
 *
 */
public class Session {
    public static enum TYPE{student,teacher};

    private String id;
    private String userName;

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    private TYPE type;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }




}
