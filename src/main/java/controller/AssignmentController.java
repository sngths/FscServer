package controller;

import data.AssignmentPool;
import data.session.Session;
import data.session.SessionManager;
import entity.transfer.received.AssignmentReceived;
import entity.transfer.response.AssignmentSend;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
    private SessionManager sessionManager;


    /**
     * 请求单个班级的作业列表
     *
     * @param token        请求时附带token参数来确认用户身份
     * @param classId      班级ID
     * @param serialNumber 请求时附带的最大序列号 根据这个序列号确定消息顺序
     *
     */
    @RequiresAuthentication
    @RequiresRoles("guest")
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
        pool.save(assignment, session.getUserName());

    }

}
