package com.tianxing.pojo.transfer.response;

import com.tianxing.pojo.info.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianxing on 16/10/29.
 * 学生用户登录成功后 获取到的个人相关信息
 */
public class StudentInfoResponse {

    private XmppServerInfo xmppServerInfo;//xmpp通信相关
    private StudentInfo studentInfo;//老师的个人信息
    private List<GroupInfo> groups;//群组信息
    private List<UserInfo> friends;//好友信息
    private ClassInfo classInfo;//班级信息


    public StudentInfoResponse(){
        xmppServerInfo = new XmppServerInfo();
        groups = new ArrayList<>();
        friends = new ArrayList<>();
    }


    /**
     * 设置xmpp用户名
     * */
    public void setXmppUsername(String username){
        xmppServerInfo.setUsername(username);
    }
    /**
     * 设置xmpp密码
     * */
    public void setXmppPassword(String password){
        xmppServerInfo.setPassword(password);
    }


    public XmppServerInfo getXmppServerInfo() {
        return xmppServerInfo;
    }



    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public List<GroupInfo> getGroups() {
        return groups;
    }

    /**
     * 添加一个群组
     * */
    public void add(GroupInfo groupInfo){
        groups.add(groupInfo);
    }

    public List<UserInfo> getFriends() {
        return friends;
    }

    /**
     * 添加一个好友信息
     * */
    public void add(UserInfo userInfo){
        friends.add(userInfo);
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }
}
