package com.tianxing.pojo.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tianxing on 16/9/8.
 */
public class TeacherInfo extends UserInfo {


    private String courseID;//科目ID
    private String courseName;//科目名称

    private List<String> classIDs;//班级ID列表

    public TeacherInfo(){
        classIDs = new ArrayList<>();
    }

    /**
     * 添加一个班级ID
     * */
    public void add(String classID){
        getClassIDs().add(classID);
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<String> getClassIDs() {
        return classIDs;
    }

    public void setClassIDs(List<String> classIDs) {
        this.classIDs = classIDs;
    }

    public void setClassID(String... id ){
        Collections.addAll(classIDs, id);
    }
}
