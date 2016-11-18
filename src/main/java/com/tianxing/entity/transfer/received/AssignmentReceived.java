package com.tianxing.entity.transfer.received;

import com.tianxing.entity.assignemnt.Image;

import java.util.List;

/**
 * Created by tianxing on 16/10/26.
 * 从客户端收到的发布作业
 */
public class AssignmentReceived {

    private String title;

    private String content;
    private String classID;
    private List<Image> images;


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Image> getImages() {
        return images;
    }

    public String getClassID() {
        return classID;
    }
}
