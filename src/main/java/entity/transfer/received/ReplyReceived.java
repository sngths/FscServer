package entity.transfer.received;

import entity.assignemnt.Image;

import java.util.List;

/**
 * Created by tianxing on 16/11/1.
 * 接收到的学生回复
 */
public class ReplyReceived {

    private String assignmentID;


    //回复内容
    private String title;
    private String content;
    private List<Image> images;


    public String getAssignmentID() {
        return assignmentID;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Image> getImages() {
        return images;
    }
}
