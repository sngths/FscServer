package data;

import data.account.AccountManager;
import entity.info.StudentInfo;
import entity.transfer.received.AssignmentReceived;
import entity.transfer.received.ReplyReceived;
import entity.transfer.response.AssignmentSend;
import entity.transfer.response.ReplySend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import util.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by tianxing on 16/10/28.
 *
 */
public class AssignmentPool {

    Logger logger = LoggerFactory.getLogger(AssignmentPool.class);
    @Autowired
    private AccountManager accountManager;

    private Map<String, CopyOnWriteArrayList<AssignmentSend>> pool = new ConcurrentHashMap<>();//按班级分类的作业列表

    //作业id对应的回复列表
    private Map<String, ConcurrentHashMap<String, ReplySend>> replyPool = new ConcurrentHashMap<>();//作业id 对应学生ID-回复 map
    //一条作业对应的回复学生ID列表
    private Map<String, CopyOnWriteArrayList<String>> replyList = new ConcurrentHashMap<>();




    /**
     * 保存一条作业
     * */
    public void saveAssignment(AssignmentReceived assignmentReceived, String teacherID){
        //找到对应班级列表
        CopyOnWriteArrayList<AssignmentSend> assignmentList = pool.get(assignmentReceived.getClassID());
        if (assignmentList == null){
            assignmentList = new CopyOnWriteArrayList<>();
            logger.info("创建班级作业列表  班级id:" + assignmentReceived.getClassID());
            pool.put(assignmentReceived.getClassID(), assignmentList);
        }

        AssignmentSend assignment = new AssignmentSend();
        assignment.setId(String.valueOf(assignmentList.size()));
        assignment.setTeacherName(accountManager.getTeacherInfoMap().get(teacherID).getNickName());
        assignment.setClassName(accountManager.getClassInfoMap().get(assignmentReceived.getClassID()).getName());
        assignment.setClassID(assignmentReceived.getClassID());

        if (assignmentReceived.getTitle() == null || assignmentReceived.getTitle().equals("")){
            assignment.setTitle(accountManager.getTeacherInfo(teacherID).getCourseName().concat("作业"));
        }else {
            assignment.setTitle(assignmentReceived.getTitle());
        }

        assignment.setDate(Server.getDate());
        assignment.setContent(assignmentReceived.getContent());
        assignment.setImages(assignmentReceived.getImages());

        logger.info("保存一条作业:" + assignment.getClassID() + "作业条数:" + String.valueOf(assignmentList.size()));
        logger.info("设置日期:" + assignment.getDate());
        assignmentList.add(assignment);
        //创建回复map
        replyPool.put(assignment.getId(), new ConcurrentHashMap<>());
        //创建回复学生ID list
        replyList.put(assignment.getId(), new CopyOnWriteArrayList<>());
    }


    /**
     * 取得一个班级的作业列表
     * */
    public List<AssignmentSend> getList(String classID, String sid){
        //找到对应的作业列表
        List<AssignmentSend> assignmentList = pool.get(classID);
        List<AssignmentSend> assignments = new ArrayList<>();
        if (assignmentList == null){
            return assignments;
        }

        int position =Integer.valueOf(sid);
        for (int i = position; i < assignmentList.size(); i++) {
            logger.info("返回列表中添加一条数据  1=" + String.valueOf(i));
            assignments.add(assignmentList.get(i));
        }
        logger.info("取得作业列表: 位置" + String.valueOf(position) + "  classID:" + classID + "作业条数:" + String.valueOf(assignmentList.size()) + "返回作业条数:" + String.valueOf(assignments.size()));
        return assignments;
    }






    /**
     * 保存一条作业的回复
     * */
    public void saveReply(ReplyReceived reply, String assignmentID, String studentID){
        ReplySend replySend = new ReplySend();
        replySend.setId(String.valueOf(replyPool.get(assignmentID).size()));
        replySend.setAssignmentID(assignmentID);
        replySend.setStudentID(studentID);
        replySend.setTitle(reply.getTitle());
        replySend.setDate(Server.getDate());
        replySend.setContent(reply.getContent());
        replySend.setImages(reply.getImages());
        replyPool.get(assignmentID).put(studentID, replySend);
        //保存提交学生ID
        replyList.get(assignmentID).add(studentID);
    }

    /**
     * 请求一条作业的回复列表
     * */
    public List<StudentInfo> getReplyStudentList(String assignmentID){
        List<StudentInfo> infoList = new ArrayList<>();

        for (String studentID : replyList.get(assignmentID)) {
            infoList.add(accountManager.getStudentInfo(studentID));
        }
        return infoList;
    }

    /**
     * 请求一条作业的回复
     * */
    public ReplySend getReply(String assignmentID, String studentID){
        return replyPool.get(assignmentID).get(studentID);
    }


}
