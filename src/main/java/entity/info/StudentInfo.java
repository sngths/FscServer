package entity.info;

import entity.info.UserInfo;

/**
 * Created by tianxing on 16/9/8.
 */
public class StudentInfo extends UserInfo {
    private String classID;//所在班级ID

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }



}
