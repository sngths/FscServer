package com.tianxing.controller;

import com.tianxing.data.assignment.AssignmentPool;
import com.tianxing.data.account.AccountManager;
import com.tianxing.data.session.Session;
import com.tianxing.data.session.SessionManager;
import com.tianxing.pojo.info.StudentInfo;
import com.tianxing.pojo.transfer.received.AssignmentReceived;
import com.tianxing.pojo.transfer.Comment;
import com.tianxing.pojo.transfer.received.ReplyReceived;
import com.tianxing.pojo.transfer.response.AssignmentSend;
import com.tianxing.pojo.transfer.response.ReplySend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tianxing on 16/9/10.
 * 处理作业相关请求
 */
@RestController
public class AssignmentController {

    private  final Logger logger = LoggerFactory.getLogger(AssignmentController.class);

    //@Autowired
    //private SecurityManager securityManager;

    @Autowired
    private AssignmentPool pool;

    @Autowired
    private AccountManager manager;

    @Autowired
    private SessionManager sessionManager;


    /**
     * 请求单个班级的作业列表
     *
     * @param token        请求时附带token参数来确认用户身份
     * @param classId      班级ID
     * @param serialNumber 请求时附带的最大序列号 根据这个序列号确定消息顺序
     *
     */
    //@RequiresAuthentication
    //@RequiresRoles("guest")
    @RequestMapping(value = "assignment/list", method = RequestMethod.GET, consumes = "application/json")
    public List<AssignmentSend> getAssignmentList(@RequestHeader(value = "token") String token, @RequestParam(value = "classID") String classId, @RequestParam(value = "serialNumber") String serialNumber) {
        //根据token判断用户身份和登陆状态
        logger.info("token= " + token);
        logger.info("classID= " + classId);
        logger.info("serialNumber= " + serialNumber);

        //Subject subject = SecurityUtils.getSubject();
        //Session session = subject.getSession();

        //logger.info(String.valueOf(session.getId()));
        //logger.info(String.valueOf(subject.isAuthenticated()));
//        ArrayList<AssignmentSend> list = new ArrayList<>();
//        list.add(new AssignmentSend());
//        list.add(new AssignmentSend());
//        list.add(new AssignmentSend());
//        list.add(new AssignmentSend());


        return pool.getList(classId, serialNumber);
    }


    /**
     * 发布作业
     *
     */
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "assignment/upload", method = RequestMethod.POST, consumes = "application/json")
    public void uploadAssignment(@RequestHeader(value = "token") String token, @RequestBody AssignmentReceived assignment) {
        System.out.println("接收到作业上传");
        //保存发布的作业
        Session session = sessionManager.getSession(token);
        if (session == null){
            return;
        }
        logger.info("取得session  用户名:".concat(session.getUserName()).concat("  token:").concat(session.getId()));
        pool.saveAssignment(assignment, session.getUserName());

    }


    /**
     * 老师请求一条作业的回复学生列表
     * */
    @RequestMapping(value = "reply/list", method = RequestMethod.GET, consumes = "application/json")
    public List<StudentInfo> getReplyStudentList(@RequestHeader(value = "token") String token, @RequestParam(value = "AssignmentID") String assignmentID){
        Session session = sessionManager.getSession(token);
        logger.info("老师请求回复学生列表  assignmentID:" + assignmentID);
        return pool.getReplyStudentList(assignmentID);
    }


    /**
     * 请求一条作业回复
     * */
    @RequestMapping(value = "reply", method = RequestMethod.GET, consumes = "application/json")
    public ReplySend getReply(@RequestHeader(value = "token") String token, @RequestParam(value = "AssignmentID") String assignmentID, @RequestParam(value = "StudentID") String studentID){
        Session session = sessionManager.getSession(token);
        logger.info("请求一条作业回复  assignmentID:" + assignmentID + "   studentID:" + studentID);
        return pool.getReply(assignmentID, studentID);

    }



    /**
     * 学生回复一条作业
     * */
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "reply/upload", method = RequestMethod.POST, consumes = "application/json")
    public ReplySend uploadReply(@RequestHeader(value = "token") String token, @RequestParam(value = "AssignmentID") String assignmentID, @RequestBody ReplyReceived reply){
        Session session = sessionManager.getSession(token);
        return pool.saveReply(reply, assignmentID,session.getUserName());
    }


    /**
     * 老师批阅一条作业
     * */
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "comment/upload", method = RequestMethod.POST, consumes = "application/json")
    public void uploadComment(@RequestHeader(value = "token") String token, @RequestBody Comment comment){
        Session session = sessionManager.getSession(token);
        pool.saveComment(comment);
    }




}
