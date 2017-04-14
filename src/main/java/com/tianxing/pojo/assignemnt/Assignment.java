package com.tianxing.pojo.assignemnt;

/**
 * Created by tianxing on 16/8/31.
 * 一条发布消息的详细信息
 */
public class Assignment {


    private String serialNumber = "";
    private String teacherName = "";
    private String className = "";



    //作业信息
    private String title = "";
    private String date = "";
    private String content;
    private String image;


    public String getSerialNumber() {
        return serialNumber;
    }

    public String getClassName() {
        return className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }
}
