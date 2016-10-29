package entity.transfer.response;

import entity.info.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianxing on 16/10/29.
 */
public class TeacherInfoResponse {

    //通信相关
    private XmppServerInfo xmppServerInfo = new XmppServerInfo();
    private TeacherInfo teacherInfo = new TeacherInfo();//老师的个人信息
    private List<GroupInfo> groups = new ArrayList<>();//群组信息
    private List<UserInfo> friends = new ArrayList<>();//好友信息
    private List<ClassInfo> classes = new ArrayList<>();//班级信息


}
