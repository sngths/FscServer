package com.tianxing.entity.transfer.response;

import com.tianxing.entity.assignemnt.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianxing on 16/10/26.
 */
public class AssignmentSend {


    private String id;
    private String teacherName;
    private String className;
    private String classID;




    //作业信息
    private String title;
    private String date;
    private String content;
    private List<Image> images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        if (images == null){
            this.images = new ArrayList<>();
        }else {
            this.images = images;
        }

    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }


}
