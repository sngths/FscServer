package data.account;

import entity.info.StudentInfo;
import entity.info.TeacherInfo;
import entity.transfer.response.StudentInfoResponse;
import entity.transfer.response.TeacherInfoResponse;

/**
 * Created by tianxing on 2016/10/29.
 */
public class AccountManager {

    public enum UserType {Teacher, Student}

    public enum CourseType {Chinese, Math, English}//课程类型


    public AccountManager() {
        /**
         * 构建一些用户 班级
         * 课程信息: 语文 数学 英语 三种课程类型
         * 班级信息: 6个年级 每个年级3个班
         * 学生信息: 每个班级30个学生
         * 老师信息: 每门课程6位老师 每位老师教3个班
         * */



    }


    /**
     * 验证用户名和密码
     */
    public Boolean verify(String username, String password) {
        return true;
    }

    /**
     * 验证用户类型
     */
    public UserType getUserType(String username) {
        return null;
    }

    /**
     * 老师用户登陆 返回老师用户信息
     */
    public TeacherInfoResponse getTeacherInfoResponse(String username) {
        TeacherInfoResponse info = new TeacherInfoResponse();

        return info;
    }


    /**
     * 学生用户登录 返回学生用户信息
     */
    public StudentInfoResponse getStudentInfoResponse(String username) {
        return null;
    }
}
