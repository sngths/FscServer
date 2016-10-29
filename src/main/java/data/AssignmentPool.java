package data;

import entity.transfer.received.AssignmentReceived;
import entity.transfer.response.AssignmentSend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Map<String, CopyOnWriteArrayList<AssignmentSend>> pool = new ConcurrentHashMap<>();



    /**
     * 保存一条作业
     * */
    public void save(AssignmentReceived assignmentReceived){
        //找到对应班级列表
        CopyOnWriteArrayList<AssignmentSend> assignmentList = pool.get(assignmentReceived.getClassID());
        if (assignmentList == null){
            assignmentList = new CopyOnWriteArrayList<>();
            logger.info("创建班级作业列表  班级id:" + assignmentReceived.getClassID());
            pool.put(assignmentReceived.getClassID(), assignmentList);
        }


        AssignmentSend assignment = new AssignmentSend();
        assignment.setSerialNumber(String.valueOf(assignmentList.size()));
        assignment.setTeacherName("");
        assignment.setClassName("");
        assignment.setClassID(assignmentReceived.getClassID());

        assignment.setTitle(assignmentReceived.getTitle());
        assignment.setDate(Server.getDate());
        assignment.setContent(assignmentReceived.getContent());
        assignment.setImages(assignmentReceived.getImages());

        logger.info("保存一条作业:" + assignment.getClassID() + "作业条数:" + String.valueOf(assignmentList.size()));
        assignmentList.add(assignment);
    }


    /**
     * 取得一个班级的作业列表
     * */
    public List<AssignmentSend> getList(String classid, String sid){
        //找到对应的作业列表
        List<AssignmentSend> assignmentList = pool.get(classid);
        List<AssignmentSend> assignments = new ArrayList<>();
        if (assignmentList == null){
            return assignments;
        }

        int position =Integer.valueOf(sid);
        for (int i = position; i < assignmentList.size(); i++) {
            logger.info("返回列表中添加一条数据  1=" + String.valueOf(i));
            assignments.add(assignmentList.get(i));
        }
        logger.info("取得作业列表: 位置" + String.valueOf(position) + "  classid:" + classid + "作业条数:" + String.valueOf(assignmentList.size()) + "返回作业条数:" + String.valueOf(assignments.size()));
        return assignments;
    }
}
