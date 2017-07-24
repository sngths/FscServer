package com.tianxing.pojo.http.response;

import com.tianxing.codes.CodesManager;
import com.tianxing.codes.encode.JsonEncoder;
import com.tianxing.codes.exception.EncodeException;
import com.tianxing.pojo.info.StudentInfo;
import com.tianxing.pojo.info.TeacherInfo;

/**
 * Created by tianxing on 2017/4/14.
 * 用户登录完成 返回的登录结果
 */
public class LoginResponse implements Response{

    private int userType;//0表示学生用户, 1表示老师用户

    private String token;
    private String refreshToken;

    private StudentInfo studentInfo;
    private TeacherInfo teacherInfo;



    public int getUserType() {
        return userType;
    }

    public String getToken() {
        return token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public void setTeacherInfo(TeacherInfo teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public TeacherInfo getTeacherInfo() {
        return teacherInfo;
    }

    @Override
    public String serialize() {
        try {
            return CodesManager.encodeAsJsonString(this);
        } catch (EncodeException e) {
            //编码错误 记入日志

            return null;
        }
    }
}
