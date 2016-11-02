package data.account;


import entity.info.ClassInfo;
import entity.info.StudentInfo;
import entity.info.TeacherInfo;
import entity.transfer.response.StudentInfoResponse;
import entity.transfer.response.TeacherInfoResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tianxing on 2016/10/29.
 *
 */
public class AccountManager {

    public enum UserType {Teacher, Student}

    public enum CourseType {Chinese, Math, English}//课程类型
    public Map<CourseType, String> CourseName = new HashMap<>();//科目类型对应的班级名称

    //private Map<String, String> classNames = new HashMap<>();//班级ID对应的班级名称
    //private Map<String, String> nicknames = new HashMap<>();//用户名对应的昵称



    private Map<String, StudentInfo> studentInfoMap;//学生ID对应的学生信息
    private Map<String, TeacherInfo> teacherInfoMap;//老是ID对应的老师信息
    private Map<String, ClassInfo> classInfoMap;//班级ID对应的班级信息


    public AccountManager() {
        studentInfoMap = new HashMap<>();
        teacherInfoMap = new HashMap<>();
        classInfoMap = new HashMap<>();
        setAccountData();
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
        if (studentInfoMap.get(username) != null){
            return UserType.Student;
        }else if (teacherInfoMap.get(username) != null){
            return UserType.Teacher;
        }else{
            return null;
        }
    }

    /**
     * 老师用户登陆 返回老师用户信息
     */
    public TeacherInfoResponse getTeacherInfoResponse(String username) {
        TeacherInfoResponse response = new TeacherInfoResponse();
        TeacherInfo teacherInfo = teacherInfoMap.get(username);
        response.setTeacherInfo(teacherInfo);
        //添加班级信息列表
        for (String classID:teacherInfo.getClassIDs()) {
            response.add(classInfoMap.get(classID));
        }
        return response;
    }


    /**
     * 学生用户登录 返回学生用户信息
     */
    public StudentInfoResponse getStudentInfoResponse(String username) {
        StudentInfoResponse response = new StudentInfoResponse();
        response.setStudentInfo(studentInfoMap.get(username));
        response.setClassInfo(classInfoMap.get(studentInfoMap.get(username).getClassID()));
        return response;
    }




    /**
     * 根据学生ID取得学生信息
     * */
    public StudentInfo getStudentInfo(String studentID){
        return studentInfoMap.get(studentID);
    }

    /**
     * 根据老师ID取得老师信息
     * */
    public TeacherInfo getTeacherInfo(String teacherID){
        return teacherInfoMap.get(teacherID);
    }



    /**
     * 构建一些用户 班级
     * 课程信息: 语文 数学 英语 三种课程类型
     * 班级信息: 6个年级 每个年级3个班
     * 学生信息: 每个班级30个学生
     * 老师信息: 每门课程6位老师 每位老师教3个班
     * */
    private void setAccountData(){
        Map<Integer, String> numTrans = new HashMap<>();
        numTrans.put(1, "一");
        numTrans.put(2, "二");
        numTrans.put(3, "三");
        numTrans.put(4, "四");
        numTrans.put(5, "五");
        numTrans.put(6, "六");
        //CourseName.put(CourseType.Chinese, "语文");
        //CourseName.put(CourseType.Math, "数学");
        //CourseName.put(CourseType.English, "英语");
        for (int i = 1; i < 7; i++) {
            //每个年级创建三名老师
            int teacherCount = teacherInfoMap.size();//已创建的老师数目
            String teacherName1 = "t".concat(String.valueOf(teacherCount+1));
            String teacherName2 = "t".concat(String.valueOf(teacherCount+2));
            String teacherName3 = "t".concat(String.valueOf(teacherCount+3));
            TeacherInfo teacher1 = new TeacherInfo();
            TeacherInfo teacher2 = new TeacherInfo();
            TeacherInfo teacher3 = new TeacherInfo();
            //设置老师用户名 昵称 头像
            teacher1.setUserName(teacherName1);
            teacher2.setUserName(teacherName2);
            teacher3.setUserName(teacherName3);
            teacher1.setNickName("老师".concat(String.valueOf(teacherCount+1)));
            teacher2.setNickName("老师".concat(String.valueOf(teacherCount+2)));
            teacher3.setNickName("老师".concat(String.valueOf(teacherCount+3)));
            teacher1.setUserIconUrl("");
            teacher1.setUserIconUrl("");
            teacher1.setUserIconUrl("");
            //设置老师科目
            teacher1.setCourseID("Chinese");
            teacher2.setCourseID("Math");
            teacher3.setCourseID("English");
            teacher1.setCourseName("语文");
            teacher2.setCourseName("数学");
            teacher3.setCourseName("英语");
            //老师信息添加到map中
            teacherInfoMap.put(teacherName1, teacher1);
            teacherInfoMap.put(teacherName2, teacher2);
            teacherInfoMap.put(teacherName3, teacher3);
            //每个年级创建三个班级
            for (int j = 1; j < 4; j++) {
                ClassInfo classInfo = new ClassInfo();
                //设置班级ID和名称
                String classID = "c".concat(String.valueOf(i)).concat("g").concat(String.valueOf(j));
                String className = numTrans.get(i).concat("年级").concat(numTrans.get(j)).concat("班");
                classInfo.setId(classID);
                classInfo.setName(className);
                classInfo.setIcon("");
                classInfo.add(teacher1);
                classInfo.add(teacher2);
                classInfo.add(teacher3);
                //老师信息中添加班级ID
                teacher1.add(classID);
                teacher2.add(classID);
                teacher3.add(classID);
                //班级信息添加到map中
                classInfoMap.put(classID, classInfo);
                //设置房间ID 和 房间名称
                classInfo.setRoomID("room_".concat(classID));
                classInfo.setRoomName(className);


                //每个班级创建30个学生
                int studentCount = studentInfoMap.size();
                for (int k = studentCount + 1; k < studentCount + 31; k++) {
                    StudentInfo student = new StudentInfo();
                    String studentName = "s".concat(String.valueOf(k));
                    student.setUserName(studentName);
                    student.setNickName("学生".concat(String.valueOf(k)));
                    student.setUserIconUrl("");
                    student.setClassID(classID);
                    classInfo.add(student);
                    //学生添加到map中
                    studentInfoMap.put(studentName, student);
                }
            }
        }
    }


    public Map<String, StudentInfo> getStudentInfoMap() {
        return studentInfoMap;
    }

    public void setStudentInfoMap(Map<String, StudentInfo> studentInfoMap) {
        this.studentInfoMap = studentInfoMap;
    }

    public Map<String, TeacherInfo> getTeacherInfoMap() {
        return teacherInfoMap;
    }

    public void setTeacherInfoMap(Map<String, TeacherInfo> teacherInfoMap) {
        this.teacherInfoMap = teacherInfoMap;
    }

    public Map<String, ClassInfo> getClassInfoMap() {
        return classInfoMap;
    }

    public void setClassInfoMap(Map<String, ClassInfo> classInfoMap) {
        this.classInfoMap = classInfoMap;
    }
}
