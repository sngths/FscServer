package entity.transfer.send;

import entity.info.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianxing on 16/8/30.
 * 教师登录完成后取得的信息
 */
public class TeacherLoginInfo {

    private String refreshToken = "dsf54g5d6fg46ds5f";
    private String token = "321sd2f1s3d21f23s";



    //通信相关
    private XmppServerInfo xmppServerInfo = new XmppServerInfo();
    private TeacherInfo teacherInfo = new TeacherInfo();//老师的个人信息
    private List<GroupInfo> groups = new ArrayList<>();//群组信息
    private List<UserInfo> friends = new ArrayList<>();//好友信息
    private List<ClassInfo> classes = new ArrayList<>();//班级信息




    public TeacherLoginInfo(){
        //构造时写入一些数据
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setRoomName("c1g1");
        groupInfo.setRoomTitle("一年级一班");
        groups.add(groupInfo);
        friends.add(UserInfo.newInstance("user1"));
        friends.add(UserInfo.newInstance("user2"));
        friends.add(UserInfo.newInstance("user3"));
        friends.add(UserInfo.newInstance("user4"));
        friends.add(UserInfo.newInstance("user5"));

        ClassInfo classInfo1 = new ClassInfo();
        classInfo1.setName("c1g1");
        classInfo1.setTitle("一年级一班");
        ClassInfo classInfo2 = new ClassInfo();
        classInfo2.setName("c1g2");
        classInfo2.setTitle("一年级二班");
        ClassInfo classInfo3 = new ClassInfo();
        classInfo3.setName("c1g3");
        classInfo3.setTitle("一年级三班");
        StudentInfo student6 = new StudentInfo();
        StudentInfo student7 = new StudentInfo();
        StudentInfo student8 = new StudentInfo();
        StudentInfo student9 = new StudentInfo();
        StudentInfo student10 = new StudentInfo();
        student6.setUserName("user6");
        student6.setNickName("用户6");
        student7.setUserName("user7");
        student7.setNickName("用户7");
        student8.setUserName("user8");
        student8.setNickName("用户8");
        student9.setUserName("user9");
        student9.setNickName("用户9");
        student10.setUserName("user10");
        student10.setNickName("用户10");
        classInfo1.addStudentInfo(student6);
        classInfo1.addStudentInfo(student7);
        classInfo1.addStudentInfo(student8);
        classInfo1.addStudentInfo(student9);
        classInfo1.addStudentInfo(student10);
        classes.add(classInfo1);
        classes.add(classInfo2);
        classes.add(classInfo3);
    }



    public String getRefreshToken() {
        return refreshToken;
    }

    public String getToken() {
        return token;
    }

    public XmppServerInfo getXmppServerInfo() {
        return xmppServerInfo;
    }

    public TeacherInfo getTeacherInfo() {
        return teacherInfo;
    }

    public List<GroupInfo> getGroups() {
        return groups;
    }

    public List<ClassInfo> getClasses() {
        return classes;
    }

    public List<UserInfo> getFriends() {
        return friends;
    }


    public void setToken(String token) {
        this.token = token;
    }
}
