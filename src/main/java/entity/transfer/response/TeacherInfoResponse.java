package entity.transfer.response;

import entity.info.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianxing on 16/10/29.
 *
 */
public class TeacherInfoResponse {


    private XmppServerInfo xmppServerInfo;//xmpp通信相关
    private TeacherInfo teacherInfo;//老师的个人信息
    private List<GroupInfo> groups;//群组信息
    private List<UserInfo> friends;//好友信息
    private List<ClassInfo> classes ;//班级信息

    public TeacherInfoResponse(){
        xmppServerInfo = new XmppServerInfo();
        teacherInfo = new TeacherInfo();
        groups = new ArrayList<>();
        friends = new ArrayList<>();
        classes = new ArrayList<>();
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

    /**
     * 添加一个班级
     * */
    public void add(ClassInfo info){
        classes.add(info);
    }



    public XmppServerInfo getXmppServerInfo() {
        return xmppServerInfo;
    }

    public void setXmppServerInfo(XmppServerInfo xmppServerInfo) {
        this.xmppServerInfo = xmppServerInfo;
    }

    public TeacherInfo getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(TeacherInfo teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public List<GroupInfo> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupInfo> groups) {
        this.groups = groups;
    }

    public List<UserInfo> getFriends() {
        return friends;
    }

    public void setFriends(List<UserInfo> friends) {
        this.friends = friends;
    }

    public List<ClassInfo> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassInfo> classes) {
        this.classes = classes;
    }
}
